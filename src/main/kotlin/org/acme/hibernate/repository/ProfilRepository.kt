package org.acme.hibernate.repository

import io.quarkus.hibernate.reactive.panache.PanacheRepository
import io.quarkus.panache.common.Sort
import io.smallrye.mutiny.Uni
import org.acme.hibernate.domain.ProfilEntity
import org.acme.hibernate.enums.TypeProfilEnum
import javax.enterprise.context.ApplicationScoped

@ApplicationScoped
class ProfilRepository : PanacheRepository<ProfilEntity> {

    fun requeteProfilEntityParLibelle(libelle: String): Uni<ProfilEntity?> {
        return find("libelle = ?1", libelle).firstResult()
    }

    fun requeteProfilEntityParTypeProfil(typeProfil: TypeProfilEnum): Uni<List<ProfilEntity>?> {
        return find("typeProfil = ?1", typeProfil).list()
    }

    fun requeteProfilEntityParActif(actif: Boolean): Uni<List<ProfilEntity>?> {
        return find("actif = ?1", Sort.by("typeProfil").and("libelle"), actif).list()
    }

    fun supprimeProfil(id: Long) {
        findById(id).onItem().transform { profil ->
            delete(profil)
        }
    }
}
