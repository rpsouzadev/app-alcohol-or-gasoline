package com.rpsouza.alcoholorgasoline

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.textfield.TextInputEditText
import com.google.android.material.textfield.TextInputLayout

class MainActivity : AppCompatActivity() {
    private lateinit var textInputAlcohol: TextInputLayout
    private lateinit var editAlcohol: TextInputEditText

    private lateinit var textInputGasoline: TextInputLayout
    private lateinit var editGasoline: TextInputEditText

    private lateinit var buttonCalculate: Button
    private lateinit var textResult: TextView


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initializeInterfaceComponents()

        buttonCalculate.setOnClickListener {
            calculateBastePrice()
        }
    }

    private fun initializeInterfaceComponents() {
        textInputAlcohol = findViewById(R.id.text_input_alcohol)
        editAlcohol = findViewById(R.id.edit_alcohol)

        textInputGasoline = findViewById(R.id.text_input_gasoline)
        editGasoline = findViewById(R.id.edit_gasoline)

        buttonCalculate = findViewById(R.id.button_calculate)
        textResult = findViewById(R.id.text_result)
    }

    private fun calculateBastePrice() {
        val alcoholPrice = editAlcohol.text.toString()
        val gasolinePrice = editGasoline.text.toString()

        val resultValidation = fieldValidation(alcoholPrice, gasolinePrice)

        if (resultValidation) {
            val calculation = alcoholPrice.toFloat() / gasolinePrice.toFloat()

            if (calculation >= 0.7) {
                textResult.text = ("É melhor utilizar gasolina")
            } else {
                textResult.text = ("É melhor utilizar álcool")
            }
        }
    }

    private fun fieldValidation(alcoholPrice: String, gasolinePrice: String): Boolean {
        textInputAlcohol.error = null
        textInputGasoline.error = null

        if (alcoholPrice.isEmpty()) {
            textInputAlcohol.error = "Digite o preço do álcool."
            return false
        }
        if (gasolinePrice.isEmpty()) {
            textInputGasoline.error = "Digite o preço da gasolina."
            return false
        }
        return true
    }
}