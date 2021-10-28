package org.acme.hibernate.repository

import io.quarkus.hibernate.reactive.panache.PanacheRepository
import io.smallrye.mutiny.Uni
import org.acme.hibernate.domain.RoleEntity
import javax.enterprise.context.ApplicationScoped

@ApplicationScoped
class RoleRepository : PanacheRepository<RoleEntity> {

    fun requeteRoleEntityParLibelle(libelle: String): Uni<RoleEntity?> {
        return find("libelle = ?1", libelle).firstResult()
    }

    fun requeteRoleEntityParCode(code: String): Uni<RoleEntity?> {
        return find("code = ?1", code).firstResult()
    }
}
