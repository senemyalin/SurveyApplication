package com.senemyalin.surveyapplication.Activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.senemyalin.surveyapplication.Model.Info
import com.senemyalin.surveyapplication.Model.PersonalInfo
import com.senemyalin.surveyapplication.R
import com.senemyalin.surveyapplication.databinding.ActivityResultBinding
import com.senemyalin.surveyapplication.databinding.ActivitySurveyBinding

class SurveyActivity : AppCompatActivity() {

    private lateinit var binding: ActivitySurveyBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivitySurveyBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val personalInfo = intent.getParcelableExtra("personalInfo") as PersonalInfo?

        with(binding) {
            txtNameSurname.text = personalInfo?.nameSurname

            btnSend.setOnClickListener {
                val color = editTextColor.text.toString()
                val sport = editTextSport.text.toString()
                val freeTimeActivity = editTextFreeTimeActivity.text.toString()

                if (color.isNotEmpty() && sport.isNotEmpty() && freeTimeActivity.isNotEmpty() && personalInfo != null) {
                    val info = Info(personalInfo, color, sport, freeTimeActivity)

                    val intent =
                        Intent(this@SurveyActivity, ResultActivity::class.java)
                    intent.putExtra("info", info)
                    finish()
                    startActivity(intent)
                } else {
                    Toast.makeText(
                        this@SurveyActivity,
                        "Please fill in the blanks!",
                        Toast.LENGTH_SHORT
                    ).show()
                }
            }

        }
    }
}