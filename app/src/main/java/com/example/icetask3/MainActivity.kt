package com.example.icetask3


import android.annotation.SuppressLint
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import kotlin.random.Random

class MainActivity : AppCompatActivity() {

    private var randomNumber = 0

    private fun generateRandomNumber() {
        randomNumber = Random.nextInt(1, 101)
    }

    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val tvMessage = findViewById<TextView>(R.id.tvMessage)
        val etGuess = findViewById<EditText>(R.id.etGuess)
        val btnGuess = findViewById<Button>(R.id.btnGuess)

        generateRandomNumber()

        btnGuess.setOnClickListener {
            val guessStr = etGuess.text.toString()

            if (guessStr.isEmpty()) {
                Toast.makeText(this, "Please enter a number", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            val guess = guessStr.toInt()

            when {
                guess < randomNumber -> tvMessage.text = "Too low! Try again."
                guess > randomNumber -> tvMessage.text = "Too high! Try again."
                else -> {
                    tvMessage.text = "Correct! The number was $randomNumber"
                    Toast.makeText(this, "You guessed it! New number generated.", Toast.LENGTH_LONG).show()
                    generateRandomNumber()
                    etGuess.text.clear()
                }
            }
        }
    }
}

