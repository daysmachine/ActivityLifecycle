package com.example.activitylifecycle

import android.content.res.Configuration
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.TextView

private const val LOG_TAG = "MyActivityLifecycle"

class MainActivity : AppCompatActivity() {

    private lateinit var counterLabel: TextView
    private lateinit var increaseButton: Button

    private lateinit var landscapeButton1: Button
    private lateinit var landscapeButton2: Button
    private lateinit var landscapeButton3: Button

    private var currentCount: Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {

        Log.v(LOG_TAG, "onCreate - begin")
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        this.connectViews()
        this.setupCallbacks()

        this.updateCounterLabel()

        Log.v(LOG_TAG, "onCreate - end")
    }

    override fun onStart() {
        Log.v(LOG_TAG, "onStart - begin")
        super.onStart()
        Log.v(LOG_TAG, "onStart - end")
    }

    override fun onResume() {
        Log.v(LOG_TAG, "onResume - begin")
        super.onResume()
        Log.v(LOG_TAG, "onResume - end")
    }

    override fun onPause() {
        Log.v(LOG_TAG, "onPause - begin")
        super.onPause()
        Log.v(LOG_TAG, "onPause - end")
    }

    override fun onStop() {
        Log.v(LOG_TAG, "onStop - begin")
        super.onStop()
        Log.v(LOG_TAG, "onStop - end")
    }

    override fun onDestroy() {
        Log.v(LOG_TAG, "onDestroy - begin")
        super.onDestroy()
        Log.v(LOG_TAG, "onDestroy - end")
    }

    private fun connectViews() {
        this.counterLabel = this.findViewById(R.id.counter_label)
        this.increaseButton = this.findViewById(R.id.counter_increase_button)

        // Grab buttons into temp variables
        // Only attempt  to assign them into our member pointer
        // if they were valid
        val tempButton1: Button? = this.findViewById(R.id.landscapeButton1)
        val tempButton2: Button? = this.findViewById(R.id.landscapeButton2)
        if ( tempButton1 != null && tempButton2 != null ) {
            this.landscapeButton1 = tempButton1
            this.landscapeButton2 = tempButton2
        }

        // Check the device's current orientation, and only attempt to connect the
        // third button if the device is in landscape mode
        if ( this.resources.configuration.orientation == Configuration.ORIENTATION_LANDSCAPE ) {
            this.landscapeButton3 = this.findViewById(R.id.landscapeButton3)
        }
    }

    private fun setupCallbacks() {
        this.increaseButton.setOnClickListener {
            this.currentCount += 1
            this.updateCounterLabel()
            println("Increase clicked!")
        }

        if ( this::landscapeButton1.isInitialized ) {
            this.landscapeButton1.setOnClickListener {
                Log.v(LOG_TAG, "Landscape button 1 was clicked")
            }
        }
        if ( this::landscapeButton2.isInitialized ) {
            this.landscapeButton2.setOnClickListener {
                Log.v(LOG_TAG, "Landscape button 2 was clicked")
            }
        }
        if ( this::landscapeButton3.isInitialized ) {
            this.landscapeButton3.setOnClickListener {
                Log.v(LOG_TAG, "Landscape button 3 was clicked")
            }
        }
    }

    private fun updateCounterLabel() {
        this.counterLabel.text = this.currentCount.toString()
    }
}