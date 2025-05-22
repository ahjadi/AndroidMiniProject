package com.example.androidminiproject.models

data class Branch(
    val id: Int,
    val name: String,
    val type: BranchType,
    val address: String,
    val phone: String,
    val hours: String,
    val locationURL: String,
    val imageUri: Int?
)
enum class BranchType{
    PHYSICAL, VIRTUAL
}