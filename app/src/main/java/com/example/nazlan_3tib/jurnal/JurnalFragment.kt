package com.example.nazlan_3tib.jurnal

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.example.nazlan_3tib.databinding.FragmentJurnalBinding
import com.google.android.material.chip.Chip

class JurnalFragment : Fragment() {

    // ViewBinding
    private var _binding: FragmentJurnalBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate layout menggunakan ViewBinding
        _binding = FragmentJurnalBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // Logika ChipGroup
        binding.chipGroupCuacaHati.setOnCheckedStateChangeListener { group, checkedIds ->
            val selectedChipId = checkedIds.firstOrNull()
            if (selectedChipId != null) {
                val chip = group.findViewById<Chip>(selectedChipId)

                Toast.makeText(requireContext(), "Filter Cuaca Hati: ${chip.text}", Toast.LENGTH_SHORT).show()

                // TODO: Nanti logika untuk memfilter isi ListView dimasukkan di sini
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