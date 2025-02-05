package com.dipesh.androidbasics.layouts

import android.os.Bundle
import androidx.activity.ComponentActivity
import com.dipesh.androidbasics.R

class RelativeLayoutActivity : ComponentActivity() {

    companion object {
        private const val TAG: String = "RelativeLayoutActivity"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_relative_layout)
    }
}