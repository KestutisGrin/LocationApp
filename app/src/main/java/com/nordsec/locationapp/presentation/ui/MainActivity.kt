package com.nordsec.locationapp.presentation.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.nordsec.locationapp.R

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setTheme(R.style.Theme_LocationApp)
        setContentView(R.layout.activity_main)
    }
}