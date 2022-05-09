package com.example.midterm

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageButton
import android.widget.TextView

class Profile : AppCompatActivity() {

    private val sharedPreferencesFile = "kotlinSharedPreference"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_profile)

        val profileCloseButton = findViewById<ImageButton>(R.id.imageButtonCloseProfile)

        profileCloseButton.setOnClickListener{
            finish()
        }

        val sharedPreferences = this.getSharedPreferences(sharedPreferencesFile, Context.MODE_PRIVATE)

        val name = sharedPreferences.getString("Name", "");

        val greetingEditText = findViewById<TextView>(R.id.textViewGreeting)

        greetingEditText.text = "Hello, $name"
    }
}