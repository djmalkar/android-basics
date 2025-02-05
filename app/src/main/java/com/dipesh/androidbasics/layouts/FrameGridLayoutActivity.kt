package com.dipesh.androidbasics.layouts

import android.os.Bundle
import androidx.activity.ComponentActivity
import com.dipesh.androidbasics.R

class FrameGridLayoutActivity : ComponentActivity() {

    companion object {
        private const val TAG: String = "FrameGridLayoutActivity"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_frame_grid_layout)
    }
}