package com.example.nazlan_3tib.jurnal

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.Toast
import com.example.nazlan_3tib.databinding.FragmentJurnalBinding
import com.google.android.material.chip.Chip

class JurnalFragment : Fragment() {

    private var _binding: FragmentJurnalBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentJurnalBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // 1. DATA DUMMY UNTUK LISTVIEW
        // Membuat data sementara berupa teks.
        // Nanti kamu bisa menggantinya dengan Model Kelas (JurnalModel) dan CustomAdapter
        val dataJurnalDummy = listOf(
            "Item 1\nSub Item 1",
            "Item 2\nSub Item 2",
            "Item 3\nSub Item 3",
            "Item 4\nSub Item 4",
            "Item 5\nSub Item 5",
            "Item 6\nSub Item 6",
            "Item 7\nSub Item 7"
        )

        // 2. PASANG ADAPTER KE LISTVIEW
        // Menggunakan ArrayAdapter sederhana untuk menampilkan teks
        val adapter = ArrayAdapter(
            requireContext(),
            android.R.layout.simple_list_item_1, // Layout default dari Android
            dataJurnalDummy
        )

        binding.listViewJurnal.adapter = adapter // Menghubungkan adapter ke listViewJurnal

        // Logika ChipGroup
        binding.chipGroupCuacaHati.setOnCheckedStateChangeListener { group, checkedIds ->
            val selectedChipId = checkedIds.firstOrNull()
            if (selectedChipId != null) {
                val chip = group.findViewById<Chip>(selectedChipId)
                Toast.makeText(requireContext(), "Filter Cuaca Hati: ${chip.text}", Toast.LENGTH_SHORT).show()
                // TODO: Nanti logika memfilter ListView
            }
        }

        binding.fabTambahJurnal.setOnClickListener {
            Toast.makeText(requireContext(), "Buka halaman tulis jurnal baru", Toast.LENGTH_SHORT).show()
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}