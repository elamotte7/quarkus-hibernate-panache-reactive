package fr.csn.ficen.api.common.rest.model.dto

data class ResponseListDTO<T>(
    val totalResultCount: Long,
    val page: Int,
    val size: Int,
    val list : List<T>
)
