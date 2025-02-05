package com.dipesh.androidbasics

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.dipesh.androidbasics.ui.theme.AndroidBasicsTheme


class LifecycleActivity : ComponentActivity() {

    companion object {
        private const val TAG: String = "ActivityLifecycle"
    }

    /**
     * Called when the activity is first created.
     * This is where you should initialize essential components.
     */
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            AndroidBasicsTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Greeting(
                        name = "Android",
                        modifier = Modifier.padding(innerPadding),
                        onClick = {
                            gotoViewsActivity()
                        }
                    )
                }
            }
        }
        Log.d(TAG, "onCreate: Activity is created");
    }

    /**
     * Called when the activity becomes visible to the user.
     */
    override fun onStart() {
        super.onStart()
        Log.d(TAG, "onStart: Activity is now visible")
    }

    /**
     * Called when the activity starts interacting with the user.
     * At this point, the activity is in the foreground.
     */
    override fun onResume() {
        super.onResume()
        Log.d(TAG, "onResume: Activity is now interactive")
    }

    /**
     * Called when the activity is partially visible but not in focus.
     * This usually happens when another activity is placed on top.
     */
    override fun onPause() {
        super.onPause()
        Log.d(TAG, "onPause: Activity is partially visible")
    }

    /**
     * Called when the activity is no longer visible to the user.
     * The activity is now in the background.
     */
    override fun onStop() {
        super.onStop()
        Log.d(TAG, "onStop: Activity is no longer visible")
    }

    /**
     * Called when the activity is being destroyed.
     * This may be due to the user closing it or the system reclaiming memory.
     */
    override fun onDestroy() {
        super.onDestroy()
        Log.d(TAG, "onDestroy: Activity is destroyed")
    }

    /**
     * Called when the activity is restarted after being stopped.
     * This happens when the user navigates back to it.
     */
    override fun onRestart() {
        super.onRestart()
        Log.d(TAG, "onRestart: Activity is restarting")
    }

    private fun gotoViewsActivity() {
        val viewsActivity = Intent(this, ViewsActivity::class.java)
        startActivity(viewsActivity)
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier, onClick: () -> Unit) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
    Button(onClick = { onClick() }) {
        Text("Basic Android UI Views")
    }
}