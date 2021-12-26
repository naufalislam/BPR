package com.coba.data

import com.google.gson.annotations.SerializedName

class LoginData (
    @SerializedName("id") val id:Int,
    @SerializedName("email") val email:String,
    @SerializedName("nama") val nama:String
    )