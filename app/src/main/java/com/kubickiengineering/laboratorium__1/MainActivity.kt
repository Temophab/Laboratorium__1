package com.kubickiengineering.laboratorium__1

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), View.OnClickListener {

    override fun onClick(v: View?) {
        when (v?.id) {
            R.id.button -> {
                add(getDoubleFromEditText1(), getDoubleFromEditText2())
            }
            R.id.subtract -> {
                subtract(getDoubleFromEditText1(), getDoubleFromEditText2())
            }
            R.id.multiply -> {
                multiply(getDoubleFromEditText1(), getDoubleFromEditText2())
            }
            R.id.divide -> {
                divide(getDoubleFromEditText1(), getDoubleFromEditText2())
            }
            R.id.modulo -> {
                modulo(getDoubleFromEditText1(), getDoubleFromEditText2())
            }
        }
    }

    private fun doSomethingBeforeAndAfter(before: () -> Unit, after: () -> Unit) {
        before()
        println("Jestem w środku")
        after()
    }

    private fun subtract(doubleFromEditText1: Double, doubleFromEditText2: Double) {
        setText(doubleFromEditText1.minus(doubleFromEditText2).toString())
    }

    private fun add(number1: Double, number2: Double) {
        setText(number1.plus(number2).toString())
        startActivity(
            Intent(this, ResultActivity::class.java)
                .apply {
                    putExtra(
                        "RESULT",
                        number1.plus(number2).toString()
                    )
                })
    }

    private fun modulo(number1: Double, number2: Double) {
        setText(number1.rem(number2).toString())
    }

    private fun multiply(number1: Double, number2: Double) {
        setText(number1.times(number2).toString())
    }

    private fun divide(number1: Double, number2: Double) {
        setText(number1.div(number2).toString())
    }

    private fun getDoubleFromEditText1(): Double {
        return editText.text.toString().toDouble()
    }

    private fun getDoubleFromEditText2(): Double {
        return editText2.text.toString().toDouble()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        button.setOnClickListener(this)
        subtract.setOnClickListener(this)
        multiply.setOnClickListener(this)
        divide.setOnClickListener(this)
        modulo.setOnClickListener(this)

        doSomethingBeforeAndAfter(
            before = { println("NAjpierw to") },
            after = { println(" To jest na końcu") }
        )
    }

    private fun setText(message: String) {
        textView.text = message
    }
}
