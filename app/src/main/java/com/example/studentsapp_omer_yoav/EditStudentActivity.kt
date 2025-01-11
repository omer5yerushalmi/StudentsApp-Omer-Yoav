package com.example.studentsapp_omer_yoav

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.studentsapp_omer_yoav.databinding.ActivityEditStudentBinding

class EditStudentActivity : AppCompatActivity() {
    private lateinit var binding: ActivityEditStudentBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityEditStudentBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Set up toolbar
        setSupportActionBar(binding.toolbarEditStudent)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.title = "Edit Student"

        val student = intent.getSerializableExtra("student") as? Student
        binding.etStudentName.setText(student?.name)
        binding.etStudentId.setText(student?.id)
        binding.etPhoneNumber.setText(student?.phoneNumber)
        binding.ivStudentImage.setImageResource(student?.imageResourceId ?: R.drawable.default_student_image)

        binding.btnUpdate.setOnClickListener {
            if (validateInput()) {
                MainActivity.students.remove(student) // Remove the old student

                val updatedStudent = Student(
                    name = binding.etStudentName.text.toString(),
                    id = binding.etStudentId.text.toString(),
                    phoneNumber = binding.etPhoneNumber.text.toString(),
                    imageResourceId = student?.imageResourceId ?: R.drawable.default_student_image
                )

                MainActivity.students.add(updatedStudent) // Add the new student

                finish() // Close the activity
            }
        }


        binding.btnDelete.setOnClickListener {
            MainActivity.students.remove(student)
            finish()
        }

        binding.btnCancel.setOnClickListener {
            finish()
        }
    }

    private fun validateInput(): Boolean {
        if (binding.etStudentName.text.toString().isBlank()) {
            binding.etStudentName.error = "Name cannot be empty"
            return false
        }
        if (binding.etStudentId.text.toString().isBlank()) {
            binding.etStudentId.error = "ID cannot be empty"
            return false
        }
        if (binding.etPhoneNumber.text.toString().isBlank()) {
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