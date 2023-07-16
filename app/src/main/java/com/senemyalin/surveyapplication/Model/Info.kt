package com.senemyalin.surveyapplication.Model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Info(
    val personalInfo: PersonalInfo,
    val color: String,
    val sport: String,
    val freeTimeActivity: String
) : Parcelable
