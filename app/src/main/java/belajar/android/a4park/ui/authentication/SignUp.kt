package belajar.android.a4park.ui.authentication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import belajar.android.a4park.databinding.ActivitySignUpBinding
import com.google.firebase.auth.FirebaseAuth

class SignUp : AppCompatActivity() {

    private lateinit var binding: ActivitySignUpBinding
    private lateinit var firebaseAuth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySignUpBinding.inflate(layoutInflater)
        setContentView(binding.root)

        supportActionBar?.hide()

        firebaseAuth = FirebaseAuth.getInstance()

        binding.btnSignUp.setOnClickListener {

            val email = binding.email.text.toString()
            val password = binding.password.text.toString()
            val conpassword = binding.confirmPassword.text.toString()

            if(email.isNotEmpty() && password.isNotEmpty() && conpassword.isNotEmpty()){
                if(password == conpassword){
                    firebaseAuth.createUserWithEmailAndPassword(email, password).addOnCompleteListener{
                        if(it.isSuccessful){
                            startActivity(Intent(this, SignIn::class.java))
                        }else{
                            Toast.makeText(this, it.exception.toString(), Toast.LENGTH_SHORT).show()
                        }
                    }
                }else{
                    Toast.makeText(this, "Password tidak sesuai", Toast.LENGTH_SHORT).show()
                }
            }else{
                Toast.makeText(this,"field belum terisi", Toast.LENGTH_SHORT).show()
            }
        }

    }
}