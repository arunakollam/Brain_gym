package com.braingym

import android.os.Bundle
import android.os.SystemClock
import android.widget.Button
import android.widget.Chronometer
import android.widget.GridLayout
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class SchulteActivity : AppCompatActivity() {

    private var nextExpected = 1
    private val totalNumbers = 25
    private lateinit var chronometer: Chronometer

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_schulte)

        chronometer = findViewById(R.id.chronometer)
        val gridLayout = findViewById<GridLayout>(R.id.schulteGrid)

        val numbers = (1..totalNumbers).toList().shuffled()

        chronometer.base = SystemClock.elapsedRealtime()
        chronometer.start()

        numbers.forEach { num ->
            val btn = Button(this).apply {
                text = num.toString()
                textSize = 20f
                setOnClickListener {
                    if (num == nextExpected) {
                        isEnabled = false
                        if (nextExpected == totalNumbers) {
                            chronometer.stop()
                            val timeTaken = (SystemClock.elapsedRealtime() - chronometer.base) / 1000
                            Toast.makeText(this@SchulteActivity, "Completed in ${timeTaken}s!", Toast.LENGTH_LONG).show()
                        } else {
                            nextExpected++
                        }
                    }
                }
            }
            gridLayout.addView(btn)
        }
    }
}
