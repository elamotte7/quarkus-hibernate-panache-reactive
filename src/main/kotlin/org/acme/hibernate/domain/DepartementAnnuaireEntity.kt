package org.acme.hibernate.domain

import java.time.LocalDate
import javax.persistence.Cacheable
import javax.persistence.Entity
import javax.persistence.Id
import javax.persistence.Table

@Entity(name = "ANNUAIRE_DEPARTEMENT")
@Table(name = "ANNUAIRE_DEPARTEMENT")
@Cacheable
data class DepartementAnnuaireEntity(
    @Id
    var code: String = "",
    var libelle: String = "",
    var dateFin: LocalDate? = null,
    var dateDebut: LocalDate? = null,
)
