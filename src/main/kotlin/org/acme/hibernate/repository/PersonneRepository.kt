package org.acme.hibernate.repository

import io.quarkus.hibernate.reactive.panache.PanacheQuery
import io.quarkus.hibernate.reactive.panache.PanacheRepository
import io.smallrye.mutiny.Uni
import org.acme.hibernate.domain.PersonneEntity
import javax.enterprise.context.ApplicationScoped

@ApplicationScoped
class PersonneRepository : PanacheRepository<PersonneEntity> {

    fun getPersonneEntityByUid(uid: String): Uni<List<PersonneEntity>?> {
        return find("uid = ?1", uid).list()
    }

    fun getPersonneEntityByUidAndOuEntite(uid: String, ou: String): Uni<PersonneEntity?> {
       return find("uid = ?1 and ouEntite = ?2", uid, ou).firstResult()
    }

    fun getListePersonneEntityPaginated(query: String, sort: String, pageIndex: Int, pageSize: Int)
            : PanacheQuery<PersonneEntity> =
        find(query).page(pageIndex, pageSize)

}
