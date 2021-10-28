package org.acme.hibernate.domain

import org.hibernate.annotations.LazyCollection
import org.hibernate.annotations.LazyCollectionOption
import java.time.LocalDateTime
import javax.persistence.*

@Entity(name = "PERSONNE")
@Table(
    name = "PERSONNE",
    uniqueConstraints =
    [UniqueConstraint(columnNames = ["UID", "OU_ENTITE"])]
)
data class PersonneEntity(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long? = null,

    @Version
    var version: Int = 0,

    var uid: String = "",

    @Column(name = "OU_ENTITE")
    var ouEntite: String = "",

    @Column(name = "CN_RATTACHEMENT")
    var cnRattachement: String = "",

    @Column(name = "TAILLE_DES_LISTES")
    var tailleDesListes: Int = 10,

    @Column(name = "HABILITE_FICEN")
    var habiliteFicen: Boolean = false,

    @Column(name = "DATE_ACCEPTATION_CGU")
    var dateAcceptationCGU: LocalDateTime? = null,

    var perimetreNational: Boolean = false,

    @OneToMany(cascade = [CascadeType.PERSIST, CascadeType.MERGE])
    @JoinTable(
        name = "PERSONNE_DEPARTEMENT_ANNUAIRE",
        joinColumns = [JoinColumn(name = "PERSONNE_ID")],
        inverseJoinColumns = [JoinColumn(name = "DEPARTEMENT_CODE")]
    )
    @LazyCollection(LazyCollectionOption.FALSE)
    var perimetreAdditionnel: MutableList<DepartementAnnuaireEntity?> = mutableListOf(),

    @ManyToMany(cascade = [CascadeType.MERGE])
    @JoinTable(
        name = "PERSONNE_PROFIL",
        joinColumns = [JoinColumn(name = "PERSONNE_ID")],
        inverseJoinColumns = [JoinColumn(name = "PROFIL_ID")]
    )
    @LazyCollection(LazyCollectionOption.FALSE)
    var profils: MutableList<ProfilEntity> = mutableListOf(),

) {
    @PreRemove
    fun supprimeAssociation() {
        this.profils.clear()
        this.perimetreAdditionnel.clear()
    }
}
