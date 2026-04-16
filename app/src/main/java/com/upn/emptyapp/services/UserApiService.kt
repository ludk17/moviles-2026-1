package com.upn.emptyapp.services

import com.upn.emptyapp.models.Usuario
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Query

interface UserApiService {
    // [GET] https://69a788b72cd1d0552690e014.mockapi.io/usuarios
    @GET("/usuarios")
    suspend fun getAllUsers(): List<Usuario>

    @GET("/usuarios") //?email=Aidan.Kuphal76@yahoo.com
    suspend fun searchUsersByEmail(@Query("email") email: String): List<Usuario>

    @POST("/usuarios")
    suspend fun create(@Body usuario: Usuario)
}