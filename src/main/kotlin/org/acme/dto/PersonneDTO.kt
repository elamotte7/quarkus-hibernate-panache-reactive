package org.acme.dto

import java.time.LocalDateTime

data class PersonneDTO(

    var id: Long? = null,

    var uid: String = "",

    var prenom: String? = null,

    var nomUsuel: String? = null,

    var sexe: String? = null,

    var jpegPhoto: String? = null,

    var ouEntite: String = "",

    var nomEntite: String? = null,

    var typeEntite: String? = null,

    var sousTypeEntite: String? = null,

    var cnRattachement: String = "",

    var telephone: String? = null,

    var email: String? = null,

    var tailleDesListes: Int = 10,

    var profils: List<ProfilDTO>? = listOf(),

    var habiliteFicen: Boolean = false,

    var dateAcceptationCGU: LocalDateTime? = null,

    var perimetreInstance: List<DepartementDTO>? = listOf(),

    var perimetreAdditionnel: List<DepartementDTO>? = listOf(),

    var perimetreNational: Boolean = false
)
