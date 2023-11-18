package com.example.primeiroprojetodevspace

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import android.widget.TextView

class ResultActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_nova_tela_dev_space)

        supportActionBar?.setHomeButtonEnabled(true)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        val tvResult = findViewById<TextView>(R.id.textview_result)
        val tvClassificacao = findViewById<TextView>(R.id.textview_classificacao)

        val result = intent.getFloatExtra("EXTRA_RESULT", 0.1f)

        tvResult.text = result.toString()

        /* Tabela IMC
        Menor que 18,5 Abaixo do peso
        Entre 18,5 e 24,9 Normal
        Entre 25,0 e 29,9 Sobrepeso I
        Entre 30,0 e 39,9 Obesidade II
        Maior que 40,0 Obesidade Grave III
         */

        val classificacao = if (result < 18.5f){
            "Abaixo do peso"
        } else if (result in 18.5f..24.9f){ //Conversao para range
            "Normal"
        } else if (result in 25.0f..29.9f){
            "Sobrepeso I"
        } else if (result >= 30.0f && result <= 39.9f){
            "Obesidade II"
        } else {
            "Obesidade Grave III"
        }

        tvClassificacao.text = getString(R.string.message_classificacao, classificacao)

    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        finish()
        return super.onOptionsItemSelected(item)
    }
}