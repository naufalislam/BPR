package com.coba.network

import com.coba.data.*
import com.coba.model.UserModel
import com.coba.model.DataKaryawanModel
import com.coba.model.PelamarModel
import retrofit2.Call
import retrofit2.http.*

interface ApiEndPoint {
    @FormUrlEncoded
    @POST("register")
    fun SignUp(
        @Field("email") email:String,
        @Field("password") password:String
    ):Call<SignUpResponse>

    @FormUrlEncoded
    @POST("login")
    fun Login(
        @Field("email") email: String,
        @Field("password") password: String
    ): Call<LoginResponse>

    @FormUrlEncoded
    @PUT("update/{id}")
    fun UpdateUser(
            @Path("id") id: Int,
            @Field("nama") nama: String,
            @Field("umur") tempattanggallahir: String,
            @Field("hobi") posisi: String
    ): Call<UpdateDataResponse>

//    @GET("/api/users?page=2")
//    fun User():Call<UserModel>


    @GET("karyawan")
    fun Karyawan():Call<PelamarModel>

    @FormUrlEncoded
    @POST("datakaryawan")
    fun TambahDatakaryawan(
            @Field("karyawan_id") karyawan_id : Int,
            @Field("pelatihan") pelatihan : String,
            @Field("pekerjaan") pekerjaan : String
    ):Call<TambahDataKaryawanResponse>

    @GET("datakaryawan/{id}")
    fun DataKaryawan(
        @Path("id") id: Int
    ):Call<DataKaryawanModel>

}