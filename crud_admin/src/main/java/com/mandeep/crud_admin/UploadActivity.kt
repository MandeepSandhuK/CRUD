
package com.mandeep.crud_admin
import android.content.Intent
import android.os.Bundle
import android.service.autofill.UserData
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import com.mandeep.crud_admin.MainActivity
import com.mandeep.crud_admin.User
import com.mandeep.crud_admin.databinding.ActivityUploadBinding
import java.util.jar.Attributes.Name


class UploadActivity : AppCompatActivity() {
    private lateinit var binding: ActivityUploadBinding
    private lateinit var databasereference: DatabaseReference
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityUploadBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.saveButton.setOnClickListener {
            val Name = binding.uploadName.text.toString()
            val Phone = binding.uploadPhone.text.toString()
            val Operator = binding.uploadOperator.text.toString()
            val Location = binding.uploadLocation.text.toString()

        databasereference = FirebaseDatabase.getInstance().getReference("phone directory")
        val users = UserData(Name, Operator, Location, Phone)
        databasereference.child(Phone).setValue(users).addOnSuccessListener {
            binding.uploadName.text.clear()
            binding.uploadPhone.text.clear()
            binding.uploadLocation.text.clear()
            binding.uploadOperator.text.clear()
            Toast.makeText(this,"Saved",Toast.LENGTH_SHORT).show()

            val intent = Intent( this@UploadActivity, MainActivity::class.java)
            startActivity(intent)
            finish()
        }.addOnFailureListener{
            Toast.makeText(this,"Failed",Toast.LENGTH_SHORT).show()
        }
        }
        }
}