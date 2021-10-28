package org.acme.dto

import org.acme.hibernate.enums.TypeProfilAdminEnum
import org.acme.hibernate.enums.TypeProfilEnum


data class ProfilDTO(
    var id: Long? = null,
    var libelle: String = "",
    var commentaire: String = "",
    var typeProfil: TypeProfilEnum = TypeProfilEnum.ANONYME,
    var typeProfilAdmin: TypeProfilAdminEnum? = null,
    var actif: Boolean = false,
    var visibleAdminChambre: Boolean = false,
    var visibleAdminConseil: Boolean = false,
    var visibleAdminCsn: Boolean = false,
    var roles: List<RoleDTO> = listOf()
)
