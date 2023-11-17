package com.example.todo_with_date.data

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class User(
    var id:String,
    var pw:String,
    var nick:String,
    var resolution:String,
): Parcelable