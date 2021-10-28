package org.acme.rest

import io.smallrye.mutiny.Uni
import org.acme.common.rest.model.dto.ResponseListDTO
import org.acme.hibernate.domain.PersonneEntity
import org.acme.hibernate.repository.PersonneRepository
import org.acme.mapper.PersonneMapper
import org.jboss.resteasy.reactive.RestQuery
import javax.inject.Inject
import javax.ws.rs.*
import javax.ws.rs.core.MediaType
import javax.ws.rs.core.Response

@Path("personnes")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
class PersonneReactiveResource @Inject constructor(
    private val personneRepository: PersonneRepository,
    private val personneMapper: PersonneMapper
) {
    @GET
    fun getPersonnes(
        @RestQuery query: String?,
        @RestQuery sort: String?,
        @RestQuery page: Int?,
        @RestQuery size: Int?
        // BUG : the following parameter doesn't work anymore
        // @BeanParam pageRequest: PaginationListeRequest
    ): Uni<Response> =
        personneRepository.getListePersonneEntityPaginated(
            query ?: "",
            sort ?: "",
            page ?: 0,
            size ?: 10
//            pageRequest.query,
//            pageRequest.sort,
//            pageRequest.page,
//            pageRequest.size
        ).list<PersonneEntity>().onItem().transform { listPersonne ->
            Response.ok(
                ResponseListDTO(
                    list = listPersonne.map {
                        personneMapper.convertToDTO(it)
                    }, page = page ?: 0,
                    size = size ?: 10,
                    totalResultCount = listPersonne.size.toLong()
                )
            )
        }.onItem().transform(
            Response.ResponseBuilder::build
        ).onFailure(Exception::class.java)
            .recoverWithItem(Response.status(Response.Status.INTERNAL_SERVER_ERROR).build())


    @GET
    @Path("{id}")
    fun getPersonneById(@PathParam("id") id: Long): Uni<Response> =
        personneRepository.findById(id).onItem().transform {
            Response.ok(
                personneMapper.convertToDTO(it)
            )
        }.onItem().transform(
            Response.ResponseBuilder::build
        ).onFailure(Exception::class.java)
            .recoverWithItem(Response.status(Response.Status.INTERNAL_SERVER_ERROR).build())

}