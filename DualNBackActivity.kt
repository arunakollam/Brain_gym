package com.braingym

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import kotlin.random.Random

class DualNBackActivity : AppCompatActivity() {

    private val nLevel = 2
    private val positions = mutableListOf<Int>()
    private val letters = mutableListOf<Char>()
    private val availableLetters = listOf('A', 'C', 'H', 'K', 'L', 'O', 'Q', 'T')
    
    private var currentIndex = 0
    private var score = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dual_nback)

        val tvGridPosition = findViewById<TextView>(R.id.tvGridPosition)
        val tvAudioLetter = findViewById<TextView>(R.id.tvAudioLetter)
        val btnMatchPos = findViewById<Button>(R.id.btnMatchPosition)
        val btnMatchAudio = findViewById<Button>(R.id.btnMatchAudio)
        val btnNext = findViewById<Button>(R.id.btnNextStep)

        btnNext.setOnClickListener {
            val nextPos = Random.nextInt(1, 10)
            val nextChar = availableLetters.random()

            positions.add(nextPos)
            letters.add(nextChar)

            tvGridPosition.text = "Position: Slot $nextPos"
            tvAudioLetter.text = "Audio Signal: $nextChar"

            currentIndex++
        }

        btnMatchPos.setOnClickListener {
            if (currentIndex > nLevel && positions[currentIndex - 1] == positions[currentIndex - 1 - nLevel]) {
                score += 10
                Toast.makeText(this, "Position Match! Score: $score", Toast.LENGTH_SHORT).show()
            } else {
                Toast.makeText(this, "Incorrect Position Match", Toast.LENGTH_SHORT).show()
            }
        }

        btnMatchAudio.setOnClickListener {
            if (currentIndex > nLevel && letters[currentIndex - 1] == letters[currentIndex - 1 - nLevel]) {
                score += 10
                Toast.makeText(this, "Audio Match! Score: $score", Toast.LENGTH_SHORT).show()
            } else {
                Toast.makeText(this, "Incorrect Audio Match", Toast.LENGTH_SHORT).show()
            }
        }
    }
}
