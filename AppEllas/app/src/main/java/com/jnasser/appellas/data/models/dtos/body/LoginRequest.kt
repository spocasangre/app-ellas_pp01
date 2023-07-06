package com.jnasser.appellas.data.models.dtos.body

data class LoginRequest(
    val email: String,
    val password: String,
    val fToken: String
)