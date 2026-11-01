package com.example.nazlan_3tib.tutorial

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.nazlan_3tib.databinding.ActivityTutorialBinding

class TutorialActivity : AppCompatActivity() {

    private lateinit var binding: ActivityTutorialBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityTutorialBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Masukkan daftar fragment ke dalam list
        val fragmentList = listOf(
            Tutorial1Fragment(),
            Tutorial2Fragment(),
            Tutorial3Fragment()
        )

        // Set adapter ke ViewPager2
        val adapter = TutorialFragmentAdapter(this, fragmentList)
        binding.viewPagerTutorial.adapter = adapter

        // Hubungkan DotsIndicator dengan ViewPager2
        binding.dotIndicator.attachTo(binding.viewPagerTutorial)
    }
}