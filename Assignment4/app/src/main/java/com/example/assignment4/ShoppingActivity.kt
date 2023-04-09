package com.example.assignment4

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class ShoppingActivity : AppCompatActivity(){

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.layout_shopping)
        var txtview = findViewById<TextView>(R.id.textView8)
        val email = intent.getStringExtra("EXTRA_EMAIL")

        txtview.text= "Welcome   $email  "

    }
}