package com.mandeep.crud_admin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.ContactsContract.CommonDataKinds.Phone
import android.widget.Toast
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import com.mandeep.crud_admin.databinding.ActivityUpdateBinding

class UpdateActivity : AppCompatActivity() {
    private lateinit var binding: ActivityUpdateBinding
    private lateinit var database: DatabaseReference
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
                binding = ActivityUpdateBinding.inflate(layoutInflater)
                setContentView(binding.root)
                binding.updateButton.setOnClickListener {
                    val Name = binding.updateName.text.toString()
                    val Phone = binding.updatePhone.text.toString()
                    val Operator = binding.updateOperator.text.toString()
                    val Location = binding.updateLocation.text.toString()
                    updateData(Phone,Name,Operator,Location)
                }
            }
            private fun updateData(phone: String, name: String, operator: String, location: String) {
                database = FirebaseDatabase.getInstance().getReference("Users")
                val user = mapOf<String,String>(
                    "name" to name,
                    "operator" to operator,
                    "location" to location
                )
                database.child(phone).updateChildren(user).addOnSuccessListener {
                    binding.updatePhone.text.clear()
                    binding.updateName.text.clear()
                    binding.updateOperator.text.clear()
                    binding.updateLocation.text.clear()
                    Toast.makeText(this,"Successfully Updated",Toast.LENGTH_SHORT).show()
                }.addOnFailureListener{
                    Toast.makeText(this,"Failed to Update",Toast.LENGTH_SHORT).show()
                }}
        }

