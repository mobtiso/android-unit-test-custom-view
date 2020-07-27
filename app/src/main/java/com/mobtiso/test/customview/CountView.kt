package com.mobtiso.test.customview

import android.content.Context
import android.util.AttributeSet
import android.widget.Button
import android.widget.LinearLayout
import android.widget.TextView

class CountView @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 0,
    defStyleRes: Int = 0
) : LinearLayout(context, attrs, defStyleAttr, defStyleRes) {

    private val buttonSubtract: Button
    private val buttonAdd: Button
    private val textViewCount: TextView

    private var countValue = 0

    private var listener: ((Int) -> Unit)? = null

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

    fun setListener(listener: ((Int) -> Unit)?) {
        this.listener = listener
    }

    private fun updateCount(value: Int) {
        countValue = value
        textViewCount.text = countValue.toString()

        listener?.invoke(countValue)
    }

    fun reset() {
        updateCount(0)
    }

}