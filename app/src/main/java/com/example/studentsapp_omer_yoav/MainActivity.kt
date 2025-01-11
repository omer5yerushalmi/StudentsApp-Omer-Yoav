package com.example.studentsapp_omer_yoav

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.studentsapp_omer_yoav.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    companion object {
        val students = mutableListOf<Student>()
    }

    private lateinit var binding: ActivityMainBinding
    private val adapter = StudentAdapter(students) { student ->
        val intent = Intent(this, StudentDetailsActivity::class.java)
        intent.putExtra("student", student)
        startActivity(intent)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val toolbar: Toolbar = binding.toolbar // Ensure this matches the ID in XML
        setSupportActionBar(toolbar)

        binding.recyclerView.layoutManager = LinearLayoutManager(this)
        binding.recyclerView.adapter = adapter

        binding.btnAddStudent.setOnClickListener {
            startActivity(Intent(this, NewStudentActivity::class.java))
        }
    }

    override fun onResume() {
        super.onResume()
        adapter.notifyDataSetChanged()
    }
}
