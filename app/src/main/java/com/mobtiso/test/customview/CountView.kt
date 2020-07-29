package com.mobtiso.test.customview

import android.content.Context
import android.util.AttributeSet
import android.widget.Button
import android.widget.LinearLayout
import android.widget.TextView
import androidx.annotation.VisibleForTesting

class CountView @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 0,
    defStyleRes: Int = 0
) : LinearLayout(context, attrs, defStyleAttr, defStyleRes) {

    private val buttonSubtract: Button
    private val buttonAdd: Button
    private val textViewCount: TextView

    @VisibleForTesting
    var countValue = 0

    init {
        inflate(context, R.layout.count_custom_view, this)

        buttonSubtract = findViewById(R.id.buttonSubtract)
        buttonAdd = findViewById(R.id.buttonAdd)
        textViewCount = findViewById(R.id.textView)

        buttonSubtract.setOnClickListener {
            updateCount(countValue - 1)
        }
        buttonAdd.setOnClickListener {
            updateCount(countValue + 1)
        }
    }

    private fun updateCount(value: Int) {
        countValue = value
        textViewCount.text = countValue.toString()
    }

    fun reset() {
        updateCount(0)
    }

}