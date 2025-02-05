package com.dipesh.androidbasics

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.dipesh.androidbasics.layouts.ConstraintLayoutActivity
import com.dipesh.androidbasics.layouts.FrameGridLayoutActivity
import com.dipesh.androidbasics.layouts.LinearLayoutActivity
import com.dipesh.androidbasics.layouts.RelativeLayoutActivity
import com.dipesh.androidbasics.ui.theme.AndroidBasicsTheme


class LifecycleActivity : ComponentActivity() {

    companion object {
        private const val TAG: String = "ActivityLifecycle"
    }

    enum class ClickViews {
        ANDROID_UI_VIEWS,
        LINEAR_LAYOUT,
        RELATIVE_LAYOUT,
        FRAME_GRID_LAYOUT,
        CONSTRAINT_LAYOUT,
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
                            navigateActivity(it)
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

    private fun navigateActivity(clickViews: ClickViews) {
        var intent : Intent? = null
        when (clickViews) {
            ClickViews.ANDROID_UI_VIEWS -> intent = Intent(this, ViewsActivity::class.java)
            ClickViews.LINEAR_LAYOUT -> intent = Intent(this, LinearLayoutActivity::class.java)
            ClickViews.RELATIVE_LAYOUT -> intent = Intent(this, RelativeLayoutActivity::class.java)
            ClickViews.FRAME_GRID_LAYOUT -> intent = Intent(this, FrameGridLayoutActivity::class.java)
            ClickViews.CONSTRAINT_LAYOUT -> intent = Intent(this, ConstraintLayoutActivity::class.java)
        }
        startActivity(intent)
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier, onClick: (LifecycleActivity.ClickViews) -> Unit) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
    Column(modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally) {
        Button(onClick = { onClick(LifecycleActivity.ClickViews.ANDROID_UI_VIEWS) }) {
            Text("Basic Android UI Views")
        }
        Spacer(modifier = Modifier.height(16.dp))
        Button(onClick = { onClick(LifecycleActivity.ClickViews.LINEAR_LAYOUT) }) {
            Text("Linear Layout")
        }
        Spacer(modifier = Modifier.height(16.dp))
        Button(onClick = { onClick(LifecycleActivity.ClickViews.RELATIVE_LAYOUT) }) {
            Text("Relative Layout")
        }
        Spacer(modifier = Modifier.height(16.dp))
        Button(onClick = { onClick(LifecycleActivity.ClickViews.FRAME_GRID_LAYOUT) }) {
            Text("Frame Grid Layout")
        }
        Spacer(modifier = Modifier.height(16.dp))
        Button(onClick = { onClick(LifecycleActivity.ClickViews.FRAME_GRID_LAYOUT) }) {
            Text("Constraint Layout")
        }
    }

}