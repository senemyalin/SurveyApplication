package com.senemyalin.surveyapplication.Model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class PersonalInfo(
    val nameSurname: String,
    val email: String,
    val phoneNumber: String
) : Parcelable
