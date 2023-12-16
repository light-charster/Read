package com.example.read.Web

import android.annotation.SuppressLint
import android.os.Bundle
import android.webkit.WebView
import android.webkit.WebViewClient
import androidx.appcompat.app.AppCompatActivity
import com.example.read.R

class WebActivity : AppCompatActivity() {
    @SuppressLint("SetJavaScriptEnabled")
    override fun onCreate(savedInstanceState: Bundle?) {
        supportActionBar?.hide()
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_web)
        val web = findViewById<WebView>(R.id.web)
        web.settings.javaScriptEnabled=true
        web.webViewClient= WebViewClient()
        val nam = intent.getStringExtra("W").toString()

        val sharedPreferences = this.getSharedPreferences("web", MODE_PRIVATE)
        val name=sharedPreferences.getString(nam, "https://bluearchive-cn.com/")
        name?.let { web.loadUrl(it) }
    }
}