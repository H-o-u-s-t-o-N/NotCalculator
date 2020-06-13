package com.example.notcalculator

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.activity_second.*

class SecondActivity : AppCompatActivity() {
    companion object{
        const val NUMBER_X = "numberX"
        const val NUMBER_Y = "numberY"
    }



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)
        gggggggggg()

    }


    fun gggggggggg(){
        val x = intent.getIntExtra(NUMBER_X, 0)
        val y = intent.getIntExtra(NUMBER_Y, 0)
        textView3.text = x.toString() + "  " + y.toString()

        btn_A.setOnClickListener() {
            val intent = Intent()
            var res = 0

            for (number in x..y){
                if (number % 3 == 0)
                    res += number
            }
            intent.putExtra(MainActivity.RESULT_TYPE_A, res.toString())
            setResult(Activity.RESULT_OK, intent)
            finish()
        }
        btn_B.setOnClickListener() {
            val intent = Intent()
            var sum = x + y
            var res = 0

            while (true){
                if (isSimple(sum)){
                    res = sum
                    break
                }
                sum++
            }

            intent.putExtra(MainActivity.RESULT_TYPE_B, res.toString())
            setResult(Activity.RESULT_OK, intent)
            finish()
        }

    }
    private fun isSimple(n: Int): Boolean {
        if(n > 1){
            for (i in 2 until n){
                if (n % i == 0)
                    return false
            }
            return true
        } else return false
    }
}