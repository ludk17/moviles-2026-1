package com.upn.emptyapp.services

import com.upn.emptyapp.models.Usuario
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST

interface UserApiService {
    // [GET] https://69de35c8410caa3d47bac8c2.mockapi.io/usuarios
    @GET("/usuarios")
    suspend fun getAllUsers(): List<Usuario>

    @POST("/usuarios")
    suspend fun createUser(@Body user: Usuario): Usuario
}