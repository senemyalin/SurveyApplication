package com.senemyalin.surveyapplication.Activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.activity.OnBackPressedCallback
import com.senemyalin.surveyapplication.Model.Info
import com.senemyalin.surveyapplication.Model.PersonalInfo
import com.senemyalin.surveyapplication.R
import com.senemyalin.surveyapplication.databinding.ActivityMainBinding
import com.senemyalin.surveyapplication.databinding.ActivityResultBinding

class ResultActivity : AppCompatActivity() {

    private lateinit var binding: ActivityResultBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityResultBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val info = intent.getParcelableExtra("info") as Info?

        with(binding) {
            txtPhone.text = info?.personalInfo?.phoneNumber
            txtEmail.text = info?.personalInfo?.email
            txtName.text = info?.personalInfo?.nameSurname
            txtColor.text = info?.color
            txtSport.text = info?.sport
            txtFreeTimeActivity.text = info?.freeTimeActivity

            btnHome.setOnClickListener {
                val intent = Intent(this@ResultActivity, MainActivity::class.java)
                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP)
                startActivity(intent)
            }
        }

        var backpressCount = 0;
        onBackPressedDispatcher.addCallback(this, object : OnBackPressedCallback(true) {
            override fun handleOnBackPressed() {
                if (backpressCount == 0) {
                    backpressCount++

                    Toast.makeText(
                        this@ResultActivity,
                        "Press again to go back to home page!",
                        Toast.LENGTH_SHORT
                    ).show()
                } else {
                    backpressCount = 0

                    val intent = Intent(this@ResultActivity, MainActivity::class.java)
                    intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP)
                    startActivity(intent)
                }
            }
        })


    }
}