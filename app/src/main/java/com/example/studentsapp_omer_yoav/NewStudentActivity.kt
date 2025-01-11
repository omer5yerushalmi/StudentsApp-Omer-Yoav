package com.example.studentsapp_omer_yoav

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.studentsapp_omer_yoav.databinding.ActivityNewStudentBinding

class NewStudentActivity : AppCompatActivity() {
    private lateinit var binding: ActivityNewStudentBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityNewStudentBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Set up toolbar
        setSupportActionBar(binding.toolbarNewStudent)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.title = "New Student"

        binding.btnSave.setOnClickListener {
            val name = binding.etStudentName.text.toString()
            val id = binding.etStudentId.text.toString()
            val phoneNumber = binding.etPhoneNumber.text.toString()

            if (validateInput(name, id, phoneNumber)) {
                val newStudent = Student(
                    id = id,
                    name = name,
                    phoneNumber = phoneNumber,
                    imageResourceId = R.drawable.default_student_image
                )
                MainActivity.students.add(newStudent)
                finish()
            }
        }
    }

    private fun validateInput(name: String, id: String, phoneNumber: String): Boolean {
        if (name.isBlank()) {
            binding.etStudentName.error = "Name cannot be empty"
            return false
        }
        if (id.isBlank()) {
            binding.etStudentId.error = "ID cannot be empty"
            return false
        }
        if (phoneNumber.isBlank()) {
            binding.etPhoneNumber.error = "Phone number cannot be empty"
            return false
        }
        return true
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }
}