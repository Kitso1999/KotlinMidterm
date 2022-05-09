package com.example.midterm

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.EditText
import android.widget.ImageButton

class MainActivity : AppCompatActivity() {
    private val sharedPreferencesFile = "kotlinSharedPreference"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val sharedPreferences = this.getSharedPreferences(sharedPreferencesFile, Context.MODE_PRIVATE)

        val loginButton = findViewById<ImageButton>(R.id.imageButtonLogin)
        val profileButton = findViewById<ImageButton>(R.id.imageButtonProfile)


        loginButton.setOnClickListener{
            val loginText = findViewById<EditText>(R.id.editTextLogin)
            val editor = sharedPreferences.edit()
            editor.putString("Name", loginText.text.toString())
            editor.commit()
            val intentProfile = Intent(this, Profile::class.java)
            startActivity(intentProfile)
        }
        profileButton.setOnClickListener{
            val intentProfile = Intent(this, Profile::class.java)
            startActivity(intentProfile)
        }
    }

}