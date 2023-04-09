package com.example.assignment4

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity

class AccountActivity:AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.layout_account)
        val textName = findViewById<EditText>(R.id.editTextTextPersonName3)
        val textLastName = findViewById<EditText>(R.id.editTextTextPersonName4)
        val textEmail = findViewById<EditText>(R.id.editTextTextPersonName5)
        val textPass = findViewById<EditText>(R.id.editTextTextPersonName6)
        val btn_create = findViewById<Button>(R.id.button3)

        btn_create.setOnClickListener{
            val name = textName.text.toString()
            val lname =textLastName.text.toString()
            val email = textEmail.text.toString()
            val pass = textPass.text.toString()
            val usr = User(name,lname,email,pass)
         Intent(this,MainActivity::class.java).also{
             it.putExtra("EXTRA_USER",usr)
             startActivity(it)
         }
        }

    }



}