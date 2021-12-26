package com.coba.data

import com.google.gson.annotations.SerializedName

class UpdateDataResponse  (
        @SerializedName("pesan") val message : String,
        @SerializedName("status") val status : Boolean
)
