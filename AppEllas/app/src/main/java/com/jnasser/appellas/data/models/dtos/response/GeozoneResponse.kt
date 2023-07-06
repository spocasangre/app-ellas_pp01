package com.app.appellas.data.models.dtos.response

data class GeozoneResponse(
    val idGeozone: Int,
    val nombre: String,
    val description: String,
    val createAt: String,
    val coordenadas: List<Coordenadas>,
    val active: Boolean
)

data class Coordenadas(
    val id_coordenada: Int,
    val latitude: Double,
    val longitud: Double
)
