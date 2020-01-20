package com.example.bmicalculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*
import kotlin.math.pow

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        buttonCalculate.setOnClickListener {
            CalculateBMI()
        }

        buttonReset.setOnClickListener {
            editTextWeight.text.clear()
            editTextHeight.text.clear()
            imageView.setImageResource(R.drawable.empty)
            textViewBMI.text = getString(R.string.BMI)

        }


    }

    private fun CalculateBMI(){
        if (editTextWeight.text.isEmpty()){
            editTextWeight.setError(getString(R.string.input_error))
            return
        }
        if (editTextHeight.text.isEmpty()){
            editTextHeight.setError(getString(R.string.input_error))
            return
        }
        val weight = editTextWeight.text.toString().toFloat()
        val height = editTextHeight.text.toString().toFloat()

        val bmi = weight/(height/100).pow(2)

        if (bmi < 18.5){
            textViewBMI.text = String.format("%s %.2f (%s)", getString(R.string.BMI),bmi,getString(R.string.under))
            imageView.setImageResource(R.drawable.under)
        }else if(bmi in 18.5..24.9){
            textViewBMI.text = String.format("%s %.2f (%s)", getString(R.string.BMI),bmi, getString(R.string.Normal))
            imageView.setImageResource(R.drawable.normal)
        }else if (bmi >= 25){
            textViewBMI.text = String.format("%s %.2f (%s)", getString(R.string.BMI),bmi, getString(R.string.Over))
            imageView.setImageResource(R.drawable.over)
        }

    }
}
