package com.example.nazlan_3tib.tenang

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.example.nazlan_3tib.databinding.FragmentTenangBinding

class TenangFragment : Fragment() {

    private var _binding: FragmentTenangBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentTenangBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // Berikan aksi klik pada menu-menu GridLayout
        binding.btnNapasKotak.setOnClickListener {
            Toast.makeText(requireContext(), "Membuka latihan Napas Kotak", Toast.LENGTH_SHORT).show()
        }

        binding.btnGrounding.setOnClickListener {
            Toast.makeText(requireContext(), "Membuka latihan Grounding", Toast.LENGTH_SHORT).show()
        }

        binding.btnSuaraAlam.setOnClickListener {
            Toast.makeText(requireContext(), "Memutar Suara Alam", Toast.LENGTH_SHORT).show()
        }

        binding.btnMeditasi.setOnClickListener {
            Toast.makeText(requireContext(), "Mulai Meditasi Singkat", Toast.LENGTH_SHORT).show()
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}