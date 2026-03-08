package com.ableassist.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import com.ableassist.R
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        installSplashScreen()
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        
        // Initial setup for accessibility
        setupAccessibility()
    }

    private fun setupAccessibility() {
        // Here we'll initialize accessibility features like TalkBack focus and UI adjustments
    }
}
