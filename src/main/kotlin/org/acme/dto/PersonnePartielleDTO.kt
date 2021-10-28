package org.acme.dto

data class PersonnePartielleDTO(

    var profils: List<Long> = listOf(),

    var habiliteFicen: Boolean = false,

    var perimetreAdditionnel: List<DepartementDTO>? = listOf(),

    var perimetreNational: Boolean = false
)
