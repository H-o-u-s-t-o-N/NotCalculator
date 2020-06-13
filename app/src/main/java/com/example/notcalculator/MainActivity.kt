package com.example.notcalculator

import android.content.Intent
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    companion object{
        const val RESULT_TYPE_A = "resultTypeA"
        const val RESULT_TYPE_B = "resultTypeB"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

    }

    fun toTheCalc(view: View) {
        val intent = Intent(this, CalculatorActivity::class.java)
        startActivity(intent)
    }

    fun toTheSecondActivity(view: View) {
        if (TextNumber_X.length() > 0 && TextNumber_Y.length() > 0) {
            textViewResult.text = "Now make chose"
            textViewResult.setBackgroundColor(resources.getColor(R.color.backgroundCalc, null))
            val intent = Intent(this, SecondActivity::class.java)
            val numberX = Integer.parseInt(TextNumber_X.text.toString())
            val numberY = Integer.parseInt(TextNumber_Y.text.toString())
            intent.putExtra(SecondActivity.NUMBER_X, numberX)
            intent.putExtra(SecondActivity.NUMBER_Y, numberY)
            startActivityForResult(intent, 1)
        }else{
            Toast.makeText(this, "no no no no, i can't do this",Toast.LENGTH_SHORT).show()
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        if (data == null){
            Toast.makeText(this, "Emmm, we have a problem",Toast.LENGTH_SHORT).show()
            return
        }
        if (data.getStringExtra(RESULT_TYPE_A) != null) {
            textViewResult.text = data.getStringExtra(RESULT_TYPE_A) + "\n\n Let's try again"
        }else if (data.getStringExtra(RESULT_TYPE_B) != null) {
            textViewResult.text = data.getStringExtra(RESULT_TYPE_B) + "\n\n Let's try again"
            textViewResult.setBackgroundColor(resources.getColor(R.color.iMustUseThisColor, null))
        }

    }

    override fun onSaveInstanceState(outState: Bundle) {
        outState?.run {
            putString("KEY", textViewResult.text.toString())
        }
        super.onSaveInstanceState(outState)
    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        super.onRestoreInstanceState(savedInstanceState)
        textViewResult.text = savedInstanceState?.getString("KEY")
    }

}