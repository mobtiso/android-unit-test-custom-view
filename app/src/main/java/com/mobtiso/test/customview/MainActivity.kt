package com.mobtiso.test.customview

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val countView = findViewById<CountView>(R.id.countView)
        val countContentTextView = findViewById<TextView>(R.id.countContentTextView)

        countView.setListener {
            countContentTextView.text = getString(R.string.count_content, it)
        }

        val buttonReset = findViewById<Button>(R.id.buttonReset)
        buttonReset.setOnClickListener {
            countView.reset()
        }

        countView.reset()
    }
}