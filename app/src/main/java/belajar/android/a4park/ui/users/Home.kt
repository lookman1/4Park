package belajar.android.a4park.ui.users

import android.content.ContentValues.TAG
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import belajar.android.a4park.databinding.ActivityHomeBinding
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase

class Home : AppCompatActivity() {

    private lateinit var binding:ActivityHomeBinding
    private var db = Firebase.firestore

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

        val userId = FirebaseAuth.getInstance().currentUser!!.uid
        val docRef = db.collection("siswa").document(userId)
        docRef.get()
            .addOnSuccessListener { document ->
                if (document != null) {
                    Log.d("tes", "DocumentSnapshot data: ${document.data}")
                    val status = document.getBoolean("status")
                    if (status == true){
                        binding.nama.text = document.getString("nama")
                        binding.nis.text = document.getString("kelas")
                        binding.status.text = "Data terverifikasi"
                    }else {
                        Log.d("tes", "gagal")
                    }
                } else {
                    Log.d("tes", "No such document")
                }
            }
            .addOnFailureListener { exception ->
                Log.d(TAG, "get failed with ", exception)
            }


//        db.collection("siswa").document(userId)
//            .get()
//            .addOnSuccessListener { result ->
//                for (document in result) {
//                    Log.d("load", "${document.id} => ${document.data}")
//                    val status = document.getBoolean("status")
//                    if (status == true){
//                        binding.nama.text = document.getString("nama")
//                        binding.nis.text = document.getString("kelas")
//                        binding.status.text = "Data terverifikasi"
//                    }
//                }
//            }
//            .addOnFailureListener { exception ->
//                Log.d(TAG, "Error getting documents: ", exception)
//            }





    }
}


//if status = true => set profile
