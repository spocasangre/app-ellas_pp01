package com.jnasser.appellas.data.models.dtos.body

data class CreateAdvisorBody(
    val type: Int,
    val fullname: String,
    val number: Int
)