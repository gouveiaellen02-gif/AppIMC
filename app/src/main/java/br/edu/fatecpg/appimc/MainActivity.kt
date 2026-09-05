package br.edu.fatecpg.appimc

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import br.edu.fatecpg.appimc.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnCalcular.setOnClickListener {
            val pesoTexto = binding.etPeso.text.toString()
            val alturaTexto = binding.etAltura.text.toString()

            if (pesoTexto.isNotEmpty() && alturaTexto.isNotEmpty()) {
                val peso = pesoTexto.toFloat()
                val altura = alturaTexto.toFloat()

                val intent = Intent(this@MainActivity, ResultadoActivity::class.java)
                intent.putExtra("EXTRA_PESO", peso)
                intent.putExtra("EXTRA_ALTURA", altura)

                startActivity(intent)
            } else {
                Toast.makeText(this, "Preencha todos os campos!", Toast.LENGTH_SHORT).show()
            }
        }
    }
}