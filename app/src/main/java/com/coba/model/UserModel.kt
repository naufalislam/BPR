package com.coba.model

data class UserModel  (val data : List<Data>){
    data class Data(
        val id: String?,
        val email: String?,
        val nama: String
    )

}