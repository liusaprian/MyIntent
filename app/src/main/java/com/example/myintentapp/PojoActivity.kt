package com.example.myintentapp

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class PojoActivity : AppCompatActivity() {

    companion object {
        const val EXTRA_PERSON = "extra_person"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_pojo)

        val pojo_received: TextView = findViewById(R.id.receive_pojo)

        val person = intent.getParcelableExtra<Person>(EXTRA_PERSON) as Person
        val textFromIntent = "Name: ${person.name}\nEmail: ${person.email}\nAge: ${person.age}\nCity: ${person.city}"
        pojo_received.text = textFromIntent
    }
}