package com.example.assignment2

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ImageButton
import android.widget.LinearLayout
import android.widget.TextView
import java.util.*

class MainActivity : AppCompatActivity(), View.OnClickListener {
    private lateinit var mainLayout: LinearLayout
    private lateinit var imageButton: ImageButton
    private lateinit var titleTextView: TextView
    private lateinit var setBackgroundButton: Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        mainLayout = findViewById(R.id.main_layout)
        imageButton = findViewById(R.id.imagebutton)
        titleTextView = findViewById(R.id.title_textview)
        setBackgroundButton = findViewById(R.id.setbackground_button)

        setBackgroundButton.setOnClickListener(this)
        imageButton.setOnClickListener(this)
    }

    override fun onClick(v: View?) {
        when (v?.id) {
            R.id.setbackground_button -> {
                // Generate random color for background
                val rnd = Random()
                val color = Color.argb(255, rnd.nextInt(256), rnd.nextInt(256), rnd.nextInt(256))
                mainLayout.setBackgroundColor(color)
            }
            R.id.imagebutton -> {
                // Generate random color for image button
                val rnd = Random()
                val color = Color.argb(255, rnd.nextInt(256), rnd.nextInt(256), rnd.nextInt(256))
                imageButton.setBackgroundColor(color)
            }
        }
    }
}


