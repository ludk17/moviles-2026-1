package com.upn.emptyapp.services

import com.upn.emptyapp.models.Usuario
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST

interface UserApiService {
    // [GET] https://69a788b72cd1d0552690e014.mockapi.io/usuarios
    @GET("/usuarios")
    suspend fun getAllUsers(): List<Usuario>

    @POST("/usuarios")
    suspend fun create(@Body usuario: Usuario)
}