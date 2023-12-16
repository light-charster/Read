package com.example.read.Advertisement

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.read.Main.MainActivity
import com.example.read.R
import com.example.read.Util.ShakeHelper
import java.util.Timer
import java.util.TimerTask

class advertisementActivity : AppCompatActivity() {
    private val shake= ShakeHelper(this)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_advertisement)
    }
    override fun onResume() {
        super.onResume()
        shake.Start()
        val intent = Intent(this, MainActivity::class.java)
        Timer().schedule(object : TimerTask() {
            override fun run() {
                startActivity(intent)
            }
        }, 5000)
    }

    override fun onPause() {
        super.onPause()
        shake.Stop()
    }
}