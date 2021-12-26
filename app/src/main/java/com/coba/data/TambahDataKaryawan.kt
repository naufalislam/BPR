package com.coba.data

import com.google.gson.annotations.SerializedName

class TambahDataKaryawan (
        @SerializedName("status") val status : Boolean,
        @SerializedName("pesan") val message : String
)