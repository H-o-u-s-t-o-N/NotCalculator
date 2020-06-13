package com.example.notcalculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import kotlinx.android.synthetic.main.activity_calculator.*
import net.objecthunter.exp4j.ExpressionBuilder
import java.lang.Exception

class CalculatorActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_calculator)

        btn_0.setOnClickListener() { setTextField("0") }
        btn_1.setOnClickListener() { setTextField("1") }
        btn_2.setOnClickListener() { setTextField("2") }
        btn_3.setOnClickListener() { setTextField("3") }
        btn_4.setOnClickListener() { setTextField("4") }
        btn_5.setOnClickListener() { setTextField("5") }
        btn_6.setOnClickListener() { setTextField("6") }
        btn_7.setOnClickListener() { setTextField("7") }
        btn_8.setOnClickListener() { setTextField("8") }
        btn_9.setOnClickListener() { setTextField("9") }
        btn_dot.setOnClickListener() { setTextField(".") }

        btn_minus.setOnClickListener() { setTextField("-") }
        btn_plus.setOnClickListener() { setTextField("+") }
        btn_multi.setOnClickListener() { setTextField("*") }
        btn_division.setOnClickListener() { setTextField("/") }
        btn_bracketOpen.setOnClickListener() { setTextField("(") }
        btn_bracketClose.setOnClickListener() { setTextField(")") }

        btn_clear.setOnClickListener() {
            mathOperation.text = ""
            resultText.text = ""
        }

        btn_delete.setOnClickListener(){
            val temp = mathOperation.text.toString()
            if (temp.isNotEmpty())
                mathOperation.text = temp.substring(0,temp.length - 1)

            resultText.text = ""
        }

        btn_equal.setOnClickListener() {
            try {

                val ex = ExpressionBuilder(mathOperation.text.toString()).build()
                val result = ex.evaluate()

                val longRes = result.toLong()
                if (result == longRes.toDouble())
                    resultText.text = longRes.toString()
                else
                    resultText.text = result.toString()

            } catch (e: Exception) {
                Log.d("Error: ", e.message)
            }
        }

    }

    fun setTextField(str: String){
        if(resultText.text != ""){
            mathOperation.text = resultText.text
            resultText.text = ""
        }

        mathOperation.append(str)
    }
}


