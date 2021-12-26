package com.coba.model

class PelamarModel  (val data : List<Data>){
    data class Data(
            val id: String?,
            val nama: String?,
            val tempatLahir: String,
            val tanggalLahir : String ,
            val posisi : String
    )

}