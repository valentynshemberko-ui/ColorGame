package com.example.colorgame

import android.graphics.Color
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    private lateinit var buttons: List<Button>
    private val colors = arrayOf(Color.RED, Color.YELLOW, Color.GREEN)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        buttons = listOf(
            findViewById(R.id.btn1), findViewById(R.id.btn2), findViewById(R.id.btn3),
            findViewById(R.id.btn4), findViewById(R.id.btn5), findViewById(R.id.btn6),
            findViewById(R.id.btn7), findViewById(R.id.btn8), findViewById(R.id.btn9),
            findViewById(R.id.btn10), findViewById(R.id.btn11), findViewById(R.id.btn12),
            findViewById(R.id.btn13), findViewById(R.id.btn14), findViewById(R.id.btn15)
        )

        startGame()
    }

    private fun startGame() {
        for (btn in buttons) {
            val randomColor = colors.random()
            btn.setBackgroundColor(randomColor)
            btn.tag = randomColor
        }
    }
}