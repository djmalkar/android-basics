package com.dipesh.androidbasics.layouts

import android.os.Bundle
import androidx.activity.ComponentActivity
import com.dipesh.androidbasics.R

class LinearLayoutActivity : ComponentActivity() {

    companion object {
        private const val TAG: String = "LinearLayoutActivity"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_linear_layout)
    }
}