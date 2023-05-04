package com.gvfs.mystudydocumentation.user

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class User (
    val email: String,
    val password: String,
    val name: String,
    val image: String
) : Parcelable

