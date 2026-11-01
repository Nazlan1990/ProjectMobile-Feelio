package com.example.nazlan_3tib.tenang

import android.content.Context
import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.Toast
import com.bumptech.glide.Glide
import com.example.nazlan_3tib.databinding.ItemTenangBinding

class TenangAdapter(
    context: Context,
    private val listLatihan: List<TenangModel>
) : ArrayAdapter<TenangModel>(context, 0, listLatihan) {

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        val binding = ItemTenangBinding.inflate(LayoutInflater.from(context), parent, false)
        val view = binding.root

        val data = listLatihan[position]

        binding.txtJudul.text = data.judul
        binding.txtDeskripsi.text = data.deskripsi

        Glide.with(context)
            .load(data.iconGambar)
            .into(binding.imgIcon)

        binding.cardTenang.setCardBackgroundColor(Color.parseColor(data.warnaBackground))

        view.setOnClickListener {
            val intent = android.content.Intent(context, com.example.nazlan_3tib.DetailActivity::class.java)

            intent.putExtra("EXTRA_JUDUL", data.judul)
            intent.putExtra("EXTRA_DESKRIPSI", data.deskripsi)

            context.startActivity(intent)
        }

        return view
    }
}