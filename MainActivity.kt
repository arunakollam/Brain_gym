package com.braingym

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import android.widget.Button

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        findViewById<Button>(R.id.btnSchulte).setOnClickListener {
            startActivity(Intent(this, SchulteActivity::class.java))
        }

        findViewById<Button>(R.id.btnDualNBack).setOnClickListener {
            startActivity(Intent(this, DualNBackActivity::class.java))
        }

        findViewById<Button>(R.id.btnChessTactics).setOnClickListener {
            startActivity(Intent(this, ChessTacticsActivity::class.java))
        }

        findViewById<Button>(R.id.btnSpatialPuzzle).setOnClickListener {
            startActivity(Intent(this, SpatialPuzzleActivity::class.java))
        }
    }
}
