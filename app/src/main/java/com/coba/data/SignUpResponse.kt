package com.coba.data

import com.google.gson.annotations.SerializedName

class SignUpResponse (
    @SerializedName("name") val name: String,
    @SerializedName("job") val password: String,
    @SerializedName("id") val id : String
)