package com.senemyalin.surveyapplication.Activity

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.senemyalin.surveyapplication.Model.PersonalInfo
import com.senemyalin.surveyapplication.databinding.ActivityPersonalInformationBinding

class PersonalInformationActivity : AppCompatActivity() {

    private lateinit var binding: ActivityPersonalInformationBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityPersonalInformationBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val nameSurname = intent.getStringExtra("nameSurname")

        with(binding) {

            txtNameSurname.text = nameSurname

            btnSave.setOnClickListener {
                val phone = editTextPhone.text.toString()
                val email = editTextEmail.text.toString()

                if (phone.isNotEmpty() && email.isNotEmpty() && !nameSurname.isNullOrEmpty()) {

                    val personalInfo = PersonalInfo(nameSurname, phone, email)

                    val intent =
                        Intent(this@PersonalInformationActivity, SurveyActivity::class.java)
                    intent.putExtra("personalInfo", personalInfo)
                    finish()
                    startActivity(intent)
                } else {
                    Toast.makeText(
                        this@PersonalInformationActivity,
                        "Please fill in the blanks!",
                        Toast.LENGTH_SHORT
                    ).show()
                }
            }
        }

    }

}

