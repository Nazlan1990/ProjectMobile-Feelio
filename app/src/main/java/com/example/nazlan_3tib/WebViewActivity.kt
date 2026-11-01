package com.example.nazlan_3tib

import android.os.Bundle
import android.webkit.WebViewClient
import androidx.appcompat.app.AppCompatActivity
import com.example.nazlan_3tib.databinding.ActivityWebViewBinding

class WebViewActivity : AppCompatActivity() {

    private lateinit var binding: ActivityWebViewBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityWebViewBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Menerima URL yang dikirim dari TenangAdapter
        val url = intent.getStringExtra("URL_WEB")

        // Konfigurasi WebView
        binding.webView.apply {
            webViewClient = WebViewClient() // Agar web dibuka di dalam aplikasi, bukan di browser luar
            settings.javaScriptEnabled = true // Mengaktifkan script web modern
            if (url != null) {
                loadUrl(url)
            }
        }
    }
}