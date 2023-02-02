package belajar.android.a4park.ui.authentication


import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import belajar.android.a4park.databinding.ActivitySignInBinding
import belajar.android.a4park.ui.users.Home
import com.google.firebase.auth.FirebaseAuth

class SignIn : AppCompatActivity() {

    private lateinit var binding: ActivitySignInBinding
    private lateinit var firebaseAuth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySignInBinding.inflate(layoutInflater)
        setContentView(binding.root)

        supportActionBar?.hide()

        firebaseAuth = FirebaseAuth.getInstance()

        binding.txRegister.setOnClickListener {
            startActivity(Intent(this, SignUp::class.java))
        }

        //login
        binding.btnSignIn.setOnClickListener {
            val email = binding.email.text.toString()
            val password = binding.password.text.toString()

            if(email.isNotEmpty() && password.isNotEmpty()){
                firebaseAuth.signInWithEmailAndPassword(email, password).addOnCompleteListener{
                    if(it.isSuccessful){
                        startActivity(Intent(this, Home::class.java))
                        Toast.makeText(this,"Selamat datang", Toast.LENGTH_SHORT).show()
                        Toast.makeText(this,"Pencet tombol di kanan bawah untuk menambah data", Toast.LENGTH_LONG).show()
                    }else{
                        Toast.makeText(this, it.exception.toString(), Toast.LENGTH_SHORT).show()
                    }
                }
            }else{
                Toast.makeText(this,"field belum terisi", Toast.LENGTH_SHORT).show()
            }
        }

    }
}