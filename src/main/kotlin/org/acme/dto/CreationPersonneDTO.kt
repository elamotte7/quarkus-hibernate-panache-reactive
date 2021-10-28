package org.acme.dto

data class CreationPersonneDTO(

    var uidPersonne: String = "",

    var ouEntite: String = "",

    var profils: List<ProfilDTO>? = listOf()
)
