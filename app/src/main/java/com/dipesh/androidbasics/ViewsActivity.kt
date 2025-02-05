package com.dipesh.androidbasics

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.KeyEvent
import android.view.MotionEvent
import android.widget.Button
import android.widget.Toast
import androidx.activity.ComponentActivity

class ViewsActivity : ComponentActivity() {

    companion object {
        private const val TAG: String = "ViewsActivity"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_views)
        setButtonClickEvents()
    }

    @SuppressLint("ClickableViewAccessibility")
    private fun setButtonClickEvents() {
        val button = findViewById<Button>(R.id.button)

        button.setOnClickListener {
            Toast.makeText(this, "Button Clicked!", Toast.LENGTH_SHORT).show()
        }

        button.setOnLongClickListener {
            Toast.makeText(this, "Long Press Detected!", Toast.LENGTH_SHORT).show()
            true // Return true to indicate event is handled
        }

        button.setOnTouchListener { v, event ->
            when (event.action) {
                MotionEvent.ACTION_DOWN -> {
                    Toast.makeText(this, "Button Pressed Down", Toast.LENGTH_SHORT).show()
                }
                MotionEvent.ACTION_UP -> {
                    Toast.makeText(this, "Button Released", Toast.LENGTH_SHORT).show()
                }
            }
            true
        }

        button.setOnFocusChangeListener { v, hasFocus ->
            if (hasFocus) {
                Toast.makeText(this, "Button Gained Focus", Toast.LENGTH_SHORT).show()
            } else {
                Toast.makeText(this, "Button Lost Focus", Toast.LENGTH_SHORT).show()
            }
        }

        button.setOnKeyListener { v, keyCode, event ->
            if (event.action == KeyEvent.ACTION_DOWN && keyCode == KeyEvent.KEYCODE_ENTER) {
                Toast.makeText(this, "Enter Key Pressed on Button", Toast.LENGTH_SHORT).show()
                true
            } else {
                false
            }
        }

    }
}