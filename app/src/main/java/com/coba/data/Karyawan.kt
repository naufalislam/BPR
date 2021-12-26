package com.coba.data

import com.google.gson.annotations.SerializedName

class Karyawan (
        @SerializedName("id") val id:Int,
        @SerializedName("email") val email:String,
        @SerializedName("umur") val umur:String,
        @SerializedName("hobi") val hobi:String,
        @SerializedName("role") val role:String
        )