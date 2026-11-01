package com.example.nazlan_3tib.beranda

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import com.example.nazlan_3tib.databinding.ItemArtikelBinding

class ArtikelAdapter(
    context: Context,
    private val listArtikel: List<ArtikelModel>
) : ArrayAdapter<ArtikelModel>(context, 0, listArtikel) {

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        val binding = ItemArtikelBinding.inflate(LayoutInflater.from(context), parent, false)
        val view = binding.root

        val data = listArtikel[position]
        binding.txtJudulArtikel.text = data.judul

        // Aksi klik membuka WebViewActivity
        view.setOnClickListener {
            val intent = android.content.Intent(context, com.example.nazlan_3tib.WebViewActivity::class.java)
            intent.putExtra("URL_WEB", data.url)
            context.startActivity(intent)
        }

        return view
    }
}