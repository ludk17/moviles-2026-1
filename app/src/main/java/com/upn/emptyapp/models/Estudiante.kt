package com.upn.emptyapp.models

import com.google.firebase.firestore.DocumentId

data class Estudiante(
    var id: String? = null,
    val nombre: String = "",
    val apellido: String = "",
)