package belajar.android.a4park.ui.users

import android.app.ProgressDialog
import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import belajar.android.a4park.databinding.ActivityPageRegisterBinding
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase
import com.google.firebase.storage.FirebaseStorage
import java.text.SimpleDateFormat
import java.time.LocalDate
import java.util.*
import java.util.logging.SimpleFormatter

class PageRegister : AppCompatActivity() {

    private lateinit var binding: ActivityPageRegisterBinding
    private var db = Firebase.firestore
    lateinit var ImageUri : Uri


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityPageRegisterBinding.inflate(layoutInflater)
        setContentView(binding.root)
        Toast.makeText(this, "Untuk mendaftar 4Park harap isi data diri di atas dengan lengkap!", Toast.LENGTH_SHORT).show()

        binding.UploadFoto.setOnClickListener{
            selectImage()
        }

        binding.btnSubmit.setOnClickListener {
            uploadData()
            uploadImage()
        }
    }


    private fun uploadData() {

        val nama = binding.dtNama.text.toString()
        val nis = binding.dtNis.text.toString()
        val kelas = binding.dtKelas.text.toString()
        val noTlp = binding.dtTelepon.text.toString()
        val status = false;

        val siswaMap = hashMapOf(
            "nama" to nama,
            "NIS" to nis,
            "kelas" to kelas,
            "noTelp" to noTlp,
            "status" to status,
        )

        val userId = FirebaseAuth.getInstance().currentUser!!.uid
        db.collection("siswa").document(userId)
            .set(siswaMap)
            .addOnSuccessListener {
                binding.dtNama.text.clear()
                binding.dtNis.text.clear()
                binding.dtKelas.text.clear()
                binding.dtTelepon.text.clear()
                Log.d("upload", "berhasil ditambahkan")
                val intent = Intent(this, Home::class.java)
                Toast.makeText(this, "Data Berhasil Disimpan", Toast.LENGTH_SHORT).show()
                startActivity(intent)
            }
            .addOnFailureListener { e ->
                Log.w("upload", "Error", e)
                Toast.makeText(this, "Data Gagal Disimpan, Cek kembali kelengkapan data", Toast.LENGTH_SHORT).show()
            }




//        TANPA DOCUMENT
//        db.collection("siswa")
//            .add(siswaMap)
//            .addOnSuccessListener { documentReference ->
//                binding.dtNama.text.clear()
//                binding.dtNis.text.clear()
//                binding.dtKelas.text.clear()
//                binding.dtTelepon.text.clear()
//                Log.d("inib", "DocumentSnapshot written with ID: ${documentReference.id}")
//                val intent = Intent(this, Home::class.java)
//                Toast.makeText(this, "Data Berhasil Disimpan", Toast.LENGTH_SHORT).show()
//                startActivity(intent)
//            }
//            .addOnFailureListener { e ->
//                Log.w("inib", "Error adding document", e)
//                Toast.makeText(this, "Data Gagal Disimpan, Cek kembali kelengkapan data", Toast.LENGTH_SHORT).show()
//
//            }
    }

    private fun uploadImage() {
        val progressDialog = ProgressDialog(this)
        progressDialog.setMessage("Uploading file...")
        progressDialog.setCancelable(false)
        progressDialog.show()

        val formatter = SimpleDateFormat("yyyy_MM_dd_HH_mm_ss", Locale.getDefault())
        val now = Date()
        val fileName = formatter.format(now)
        val storageReference = FirebaseStorage.getInstance().getReference("image/$fileName")

        storageReference.putFile(ImageUri).
        addOnSuccessListener{
            binding.UploadFoto.setImageURI(null)
            Toast.makeText(this,"Successfuly Uploaded", Toast.LENGTH_SHORT).show()
            if (progressDialog.isShowing)progressDialog.dismiss()
        }.addOnFailureListener{
            if (progressDialog.isShowing)progressDialog.dismiss()
            Toast.makeText(this,"Failed", Toast.LENGTH_SHORT).show()
        }

    }

    private fun selectImage() {
        val intent = Intent()
        intent.type = "image/*"
        intent.action = Intent.ACTION_GET_CONTENT

        startActivityForResult(intent, 100)
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        if( requestCode == 100 && resultCode == RESULT_OK){

            ImageUri = data?.data!!
            binding.UploadFoto.setImageURI(ImageUri)
            binding.txUploadFoto.setText("")
            Toast.makeText(this,"Pastikan Gambar jelas untuk mempermudah pengecekan!",Toast.LENGTH_LONG).show()


        }
    }



}