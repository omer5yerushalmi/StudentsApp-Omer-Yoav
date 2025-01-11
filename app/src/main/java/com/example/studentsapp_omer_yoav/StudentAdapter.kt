package com.example.studentsapp_omer_yoav

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.studentsapp_omer_yoav.databinding.ItemStudentBinding

class StudentAdapter(
    private val students: List<Student>,
    private val onRowClick: (Student) -> Unit
) : RecyclerView.Adapter<StudentAdapter.StudentViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): StudentViewHolder {
        val binding = ItemStudentBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return StudentViewHolder(binding)
    }

    override fun onBindViewHolder(holder: StudentViewHolder, position: Int) {
        holder.bind(students[position])
    }

    override fun getItemCount() = students.size

    inner class StudentViewHolder(private val binding: ItemStudentBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(student: Student) {
            with(binding) {
                tvStudentName.text = student.name
                tvStudentId.text = student.id
                tvPhoneNumber.text = student.phoneNumber
                cbPresent.isChecked = student.isPresentInClass
                ivStudentImage.setImageResource(student.imageResourceId)

                // Update checkbox handling
                cbPresent.setOnCheckedChangeListener { _, isChecked ->
                    student.isPresentInClass = isChecked
                }

                root.setOnClickListener { onRowClick(student) }
            }
        }
    }
}