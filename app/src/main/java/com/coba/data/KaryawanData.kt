package com.coba.data

import com.google.gson.annotations.SerializedName

class KaryawanData (
        @SerializedName("id") val id:Int,
        @SerializedName("pelatihan") val pelatihan:String,
        @SerializedName("pekerjaan") val pekerjaan:String
)