package com.mobtiso.test.customview

import android.content.Context
import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.test.core.app.ApplicationProvider
import com.google.common.truth.Truth.assertThat
import org.junit.Test
import org.junit.runner.RunWith
import org.robolectric.RobolectricTestRunner
import org.robolectric.annotation.Config

@RunWith(RobolectricTestRunner::class)
@Config(sdk = [28])
class CountViewTest {

    private val context = ApplicationProvider.getApplicationContext<Context>();
    private val countView = CountView(context)
    private val buttonAdd = countView.findViewById<Button>(R.id.buttonAdd)
    private val textViewValue = countView.findViewById<TextView>(R.id.textView)

    @Test
    fun testSetUpIsOk() {
        assertThat(countView.context).isNotNull()
    }

    @Test
    fun testUiOfButtonAdd() {
        assertThat(buttonAdd.isEnabled).isTrue()
        assertThat(buttonAdd.visibility).isEqualTo(View.VISIBLE)
        assertThat(buttonAdd.text).isEqualTo(context.getString(R.string.button_add))
        assertThat(buttonAdd.textSize).isEqualTo(context.resources.getDimension(R.dimen.count_text_size))
    }

    @Test
    fun testReset() {
        countView.reset()
        assertThat(countView.countValue).isEqualTo(0)
        assertThat(textViewValue.text.toString()).isEqualTo("0")
    }

    @Test
    fun testButtonAddIsClicked() {
        countView.reset()

        buttonAdd.performClick()
        assertThat(countView.countValue).isEqualTo(1)
        assertThat(textViewValue.text.toString()).isEqualTo("1")

        buttonAdd.performClick()
        assertThat(countView.countValue).isEqualTo(2)
        assertThat(textViewValue.text.toString()).isEqualTo("2")
    }
}