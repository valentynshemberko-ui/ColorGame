package com.example.colorgame

import android.graphics.Color
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AlertDialog
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

        for (btn in buttons) {
            btn.setOnClickListener {
                changeColor(it as Button)
                checkWinCondition()
            }
        }
    }

    private fun startGame() {
        for (btn in buttons) {
            val randomColor = colors.random()
            btn.setBackgroundColor(randomColor)
            btn.tag = randomColor
        }
    }

    private fun changeColor(btn: Button) {
        val currentColor = btn.tag as Int
        val currentIndex = colors.indexOf(currentColor)
        val nextIndex = (currentIndex + 1) % colors.size
        val nextColor = colors[nextIndex]

        btn.setBackgroundColor(nextColor)
        btn.tag = nextColor
    }

    private fun checkWinCondition() {
        val firstColor = buttons[0].tag as Int

        val allMatch = buttons.all { (it.tag as Int) == firstColor }

        if (allMatch) {
            AlertDialog.Builder(this)
                .setTitle("You Win!")
                .setMessage("All squares match! Start a new game?")
                .setPositiveButton("Restart") { _, _ -> startGame() }
                .setCancelable(false)
                .show()
        }
    }
}