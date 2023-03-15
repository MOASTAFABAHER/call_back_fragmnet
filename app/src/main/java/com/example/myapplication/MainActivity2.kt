package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import androidx.fragment.app.FragmentManager

class MainActivity2 : AppCompatActivity() {
    lateinit var  profileText:TextView
    lateinit var  SettingsText:TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)
        profileText=findViewById(R.id.profile_id)
        SettingsText=findViewById(R.id.settings_id)
        profileText.setOnClickListener{
            supportFragmentManager.beginTransaction().replace(R.id.fragment_container_id,ProfileFragment()).commit()
        }
        SettingsText.setOnClickListener{
            supportFragmentManager.beginTransaction().replace(R.id.fragment_container_id,SettingsFragment()).commit()
        }
    }
}