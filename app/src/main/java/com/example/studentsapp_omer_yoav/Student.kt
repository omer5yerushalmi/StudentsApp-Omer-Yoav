package com.example.studentsapp

import java.io.Serializable

data class Student(
    var id: String,
    var name: String,
    var phoneNumber: String = "",
    var isPresentInClass: Boolean = false,
    var imageResourceId: Int = R.drawable.default_student_image
) : Serializable