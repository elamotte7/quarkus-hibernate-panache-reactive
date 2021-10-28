package org.acme.hibernate.domain

import org.acme.hibernate.enums.TypeProfilAdminEnum
import org.acme.hibernate.enums.TypeProfilEnum
import javax.persistence.*

@Entity(name = "PROFIL")
@Table(name = "PROFIL")
data class ProfilEntity(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long? = null,

    @Version
    var version: Int? = 0,

    var libelle: String = "",

    @Enumerated(EnumType.STRING)
    var typeProfil: TypeProfilEnum = TypeProfilEnum.ANONYME,

    @Enumerated(EnumType.STRING)
    var typeProfilAdmin: TypeProfilAdminEnum? = null,

    @Column(columnDefinition = "TEXT")
    var commentaire: String = "",

    var actif: Boolean = false,
    var visibleAdminChambre: Boolean = false,
    var visibleAdminConseil: Boolean = false,
    var visibleAdminCsn: Boolean = false,

    @ManyToMany(fetch = FetchType.EAGER, cascade = [CascadeType.MERGE])
    @JoinTable(
        name = "PROFIL_ROLE",
        joinColumns = [JoinColumn(name = "PROFIL_ID")],
        inverseJoinColumns = [JoinColumn(name = "ROLE_ID")]
    )
    var roles: MutableList<RoleEntity> = mutableListOf(),

    @ManyToMany(mappedBy = "profils", fetch = FetchType.LAZY, cascade = [CascadeType.MERGE])
    var personnes: MutableList<PersonneEntity> = mutableListOf(),

    ) {
    @PreRemove
    fun supprimeAssociation() {
        this.roles.clear()
        this.personnes.forEach {
            it.profils.remove(this)
        }
    }
}
