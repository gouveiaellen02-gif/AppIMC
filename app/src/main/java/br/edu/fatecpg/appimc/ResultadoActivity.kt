package br.edu.fatecpg.appimc

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import br.edu.fatecpg.appimc.databinding.ActivityResultadoBinding
import java.util.Locale

class ResultadoActivity : AppCompatActivity() {

    private lateinit var binding: ActivityResultadoBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityResultadoBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val peso = intent.getFloatExtra("EXTRA_PESO", 0f)
        val altura = intent.getFloatExtra("EXTRA_ALTURA", 0f)

        if (altura > 0f) {
            val imc = peso / (altura * altura)
            val classificacao = obterClassificacao(imc)

            binding.tvImc.text = String.format(Locale.getDefault(), "IMC: %.2f", imc)
            binding.tvClassificacao.text = classificacao
        }
    }

    private fun obterClassificacao(imc: Float): String {
        return when {
            imc < 18.5f -> "Abaixo do peso"
            imc in 18.5f..24.9f -> "Peso ideal"
            imc in 25.0f..29.9f -> "Sobrepeso"
            else -> "Obesidade"
        }
    }
}