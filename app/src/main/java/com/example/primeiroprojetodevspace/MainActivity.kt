package com.example.primeiroprojetodevspace

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        val btnCalcular: Button = findViewById(R.id.btnCalcular)
        val edtPeso: EditText = findViewById(R.id.edttext_peso)
        val edtAltura: EditText = findViewById(R.id.edttext_altura)

        btnCalcular.setOnClickListener {

            val alturaStr = edtAltura.text.toString()
            val pesoStr = edtPeso.text.toString()

            if (alturaStr.isNotEmpty() && pesoStr.isNotEmpty()) {
                val altura: Float = edtAltura.text.toString().toFloat()
                val peso: Float = edtPeso.text.toString().toFloat()

                val alturaFinal = altura * altura
                val resultado: Float = peso / alturaFinal

                val intent = Intent(this, ResultActivity::class.java)
                    .apply {
                        putExtra("EXTRA_RESULT", resultado)
                    }
                startActivity(intent)
            } else{
                Toast.makeText(this, "Preencher todos os campos", Toast.LENGTH_LONG ).show()
            }
        }
    }
}