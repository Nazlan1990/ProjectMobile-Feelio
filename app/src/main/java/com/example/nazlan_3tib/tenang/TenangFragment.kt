package com.example.nazlan_3tib.tenang

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.nazlan_3tib.R
import com.example.nazlan_3tib.databinding.FragmentTenangBinding

class TenangFragment : Fragment() {

    private var _binding: FragmentTenangBinding? = null
    private val binding get() = _binding!!

    private val listLatihan = listOf(
        TenangModel("Napas Kotak", "Latihan dasar untuk meredakan panik seketika", R.drawable.ic_tenang, "#6DB49C"),
        TenangModel("Meditasi Tidur", "Pelajari tidur berkualitas untuk esok yang baik", R.drawable.ic_insight, "#588FC4"),
        TenangModel("Grounding 5-4-3-2-1", "Kembali ke masa kini saat pikiran berantakan", R.drawable.ic_jurnal, "#FBC96C")
    )

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentTenangBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // Memasang Adapter ke ListView
        val adapter = TenangAdapter(requireContext(), listLatihan)
        binding.listViewTenang.adapter = adapter
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}