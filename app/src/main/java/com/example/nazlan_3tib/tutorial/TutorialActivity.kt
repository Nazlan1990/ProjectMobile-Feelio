package com.example.nazlan_3tib.tutorial

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.viewpager2.widget.ViewPager2
import com.example.nazlan_3tib.LoginActivity
import com.example.nazlan_3tib.databinding.ActivityTutorialBinding

class TutorialActivity : AppCompatActivity() {

    private lateinit var binding: ActivityTutorialBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityTutorialBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val fragmentList = listOf(
            Tutorial1Fragment(),
            Tutorial2Fragment(),
            Tutorial3Fragment()
        )

        val adapter = TutorialFragmentAdapter(this, fragmentList)
        binding.viewPagerTutorial.adapter = adapter
        binding.dotIndicator.attachTo(binding.viewPagerTutorial)

        // Logika Tombol Lewati (Langsung ke Login)
        binding.btnLewati.setOnClickListener {
            goToLogin()
        }

        // Logika Tombol Lanjut / Mulai (Materi Pertemuan 9)
        binding.btnLanjut.setOnClickListener {
            val page = binding.viewPagerTutorial.currentItem
            if (page == fragmentList.lastIndex) {
                // Jika halaman terakhir, pergi ke Login
                goToLogin()
            } else {
                // Jika bukan halaman terakhir, geser ke halaman berikutnya
                binding.viewPagerTutorial.setCurrentItem(page + 1, true)
            }
        }

        // Memantau perubahan halaman untuk mengubah teks tombol (Materi Pertemuan 9)
        binding.viewPagerTutorial.registerOnPageChangeCallback(object : ViewPager2.OnPageChangeCallback() {
            override fun onPageSelected(position: Int) {
                val isLastPage = position == fragmentList.lastIndex

                // Sembunyikan 'Lewati' jika di halaman terakhir
                binding.btnLewati.visibility = if (isLastPage) View.INVISIBLE else View.VISIBLE

                // Ubah teks 'Lanjut' menjadi 'Mulai' di halaman terakhir
                binding.btnLanjut.text = if (isLastPage) "Mulai" else "Lanjut"
            }
        })
    }

    private fun goToLogin() {
        startActivity(Intent(this, LoginActivity::class.java))
        finish() // Tutup TutorialActivity agar tidak bisa di-back
    }
}