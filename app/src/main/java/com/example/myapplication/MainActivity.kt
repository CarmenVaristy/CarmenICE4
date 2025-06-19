package com.example.myapplication

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        val number1Input = findViewById<EditText>(R.id.number1)
        val number2Input = findViewById<EditText>(R.id.number2)
        val resultText = findViewById<TextView>(R.id.resultText)

        val addBtn = findViewById<Button>(R.id.btnAdd)
        val subtractBtn = findViewById<Button>(R.id.btnSubtract)
        val multiplyBtn = findViewById<Button>(R.id.btnMultiply)
        val divideBtn = findViewById<Button>(R.id.btnDivide)
        val clearBtn = findViewById<Button>(R.id.btnClear) // NEW button

        fun doCalculation(op: String) {
            val input1 = number1Input.text.toString()
            val input2 = number2Input.text.toString()

            if (input1.isEmpty() || input2.isEmpty()) {
                resultText.text = "Please enter both numbers"
                return
            }

            val num1 = input1.toDouble()
            val num2 = input2.toDouble()
            val result = when (op) {
                "+" -> num1 + num2
                "-" -> num1 - num2
                "*" -> num1 * num2
                "/" -> if (num2 == 0.0) {
                    resultText.text = "Can't divide by zero"
                    return
                } else num1 / num2
                else -> 0.0
            }

            resultText.text = "Result: $result"
        }

// Button click listeners
        addBtn.setOnClickListener { doCalculation("+") }
        subtractBtn.setOnClickListener { doCalculation("-") }
        multiplyBtn.setOnClickListener { doCalculation("*") }
        divideBtn.setOnClickListener { doCalculation("/") }
        clearBtn.setOnClickListener { // NEW feature
            number1Input.text.clear()
            number2Input.text.clear()
            resultText.text = ""
        }
    }
}

//Android Developers, 2024. Build your first app. [online] Android Developers. Available at: https://developer.android.com/training/basics/firstapp [Accessed 19 Jun 2025].

//JetBrains, 2024. Kotlin Documentation. [online] Kotlinlang.org. Available at: https://kotlinlang.org/docs/home.html [Accessed 19 Jun 2025].

//Google, 2024. Activities and Intents. [online] Android Developers. Available at: https://developer.android.com/guide/components/activities/intro-activities [Accessed 19 Jun 2025].
