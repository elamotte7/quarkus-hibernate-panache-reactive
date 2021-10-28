package org.acme.hibernate.domain

import javax.persistence.CascadeType
import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.FetchType
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id
import javax.persistence.ManyToMany
import javax.persistence.PreRemove
import javax.persistence.Table
import javax.persistence.Version

@Entity(name = "ROLE")
@Table(name = "ROLE")
data class RoleEntity(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long? = null,

    @Version
    var version: Int? = 0,

    var libelle: String = "",

    var code: String = "",

    @Column(columnDefinition = "TEXT")
    var commentaire: String = "",

    @ManyToMany(mappedBy = "roles", fetch = FetchType.LAZY, cascade = [CascadeType.MERGE])
    var profils: MutableList<ProfilEntity> = mutableListOf()
) {
    @PreRemove
    fun supprimeAssociation() {
        this.profils.clear()
    }
}
