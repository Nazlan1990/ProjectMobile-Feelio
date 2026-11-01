package com.example.nazlan_3tib.beranda

import android.content.Context.MODE_PRIVATE
import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AlertDialog
import com.example.nazlan_3tib.DetailActivity
import com.example.nazlan_3tib.LoginActivity
import com.example.nazlan_3tib.databinding.FragmentBerandaBinding
import com.google.android.material.snackbar.Snackbar

class BerandaFragment : Fragment() {

    private var _binding: FragmentBerandaBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentBerandaBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // Mengambil data username dari SharedPreferences
        val sharedPref = requireContext().getSharedPreferences("user_pref", MODE_PRIVATE)
        val username = sharedPref.getString("username", "Pengguna")

        val listArtikel = listOf(
            ArtikelModel("5 Persiapan Curhat ke Psikolog", "https://pijarpsikologi.org/blog/ingin-konsultasi-ke-psikolog-ketahui-dulu-hal-ini"),
            ArtikelModel("Manfaat Konseling Karyawan", "https://kampuspsikologi.com/konseling-industri-dan-organisasi/"),
            ArtikelModel("Ragu dengan Konseling Online?", "https://hellosehat.com/mental/mental-lainnya/konseling-online-psikolog/")
        )

        val artikelAdapter = ArtikelAdapter(requireContext(), listArtikel)
        binding.listViewArtikel.adapter = artikelAdapter

        binding.txtUsername.text = username

        // Menerapkan Snackbar
        binding.btnSnackBar.setOnClickListener {
            Snackbar.make(binding.root, "Cuaca hati hari ini berhasil dicatat!", Snackbar.LENGTH_LONG)
                .setAction("Tutup") {
                    // Aksi jika tombol tutup ditekan (opsional)
                }
                .show()
        }

        // Menerapkan AlertDialog untuk Logout
        binding.btnLogout.setOnClickListener {
            AlertDialog.Builder(requireContext())
                .setTitle("Logout")
                .setMessage("Apakah Anda yakin ingin keluar dari Feelio?")
                .setPositiveButton("Ya") { dialog, _ ->
                    // Hapus sesi login
                    val editor = sharedPref.edit()
                    editor.clear()
                    editor.apply()

                    dialog.dismiss()

                    // Pindah ke LoginActivity
                    val intent = Intent(requireContext(), LoginActivity::class.java)
                    startActivity(intent)
                    requireActivity().finish()
                }
                .setNegativeButton("Batal") { dialog, _ ->
                    dialog.dismiss()
                }
                .show()
        }
        binding.btnDetail.setOnClickListener {
            val intent = Intent(requireContext(), DetailActivity::class.java)
            startActivity(intent)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}