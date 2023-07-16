package com.senemyalin.surveyapplication.Activity

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.senemyalin.surveyapplication.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        with(binding){
            btnStart.setOnClickListener {
                val nameSurname = editText.text.toString()

                if(nameSurname.isNotEmpty()){
                    val intent = Intent(this@MainActivity, PersonalInformationActivity::class.java)
                    intent.putExtra("nameSurname", nameSurname)
                    startActivity(intent)
                }
            }
        }
    }

}