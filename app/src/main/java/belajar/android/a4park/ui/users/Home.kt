package belajar.android.a4park.ui.users

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import belajar.android.a4park.databinding.ActivityHomeBinding

class Home : AppCompatActivity() {

    private lateinit var binding:ActivityHomeBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHomeBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.cardAturan.setOnClickListener{
            startActivity(Intent(this, PageAturanMengemudi::class.java))
        }

        binding.cardLaluLintas.setOnClickListener {
            startActivity(Intent(this, PageLaluLintas::class.java))
        }

        binding.btnRegister.setOnClickListener {
            startActivity(Intent(this, PageRegister::class.java))
        }
    }
}