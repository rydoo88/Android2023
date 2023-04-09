package com.example.assignment4

import java.io.Serializable

data class User(
    val fname:String, val lname:String, val email:String,val pass:String) : Serializable
