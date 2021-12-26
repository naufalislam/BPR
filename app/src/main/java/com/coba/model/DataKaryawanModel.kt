package com.coba.model

class DataKaryawanModel ( val data : List<DataKaryawanModel.Data>){
    data class Data(
        val id: String?,
        val karyawan_id : String?,
        val pekerjaan : String?,
        val pelatihan : String
        )
}
