package org.acme.rest

import io.smallrye.mutiny.Uni
import org.acme.hibernate.domain.PersonneEntity
import org.acme.hibernate.repository.PersonneRepository
import org.acme.mapper.PersonneMapper
import javax.inject.Inject
import javax.ws.rs.GET
import javax.ws.rs.Path
import javax.ws.rs.Produces
import javax.ws.rs.core.MediaType
import javax.ws.rs.core.Response

@Path("")
class ReactiveGreetingResource @Inject constructor(
    private val personneRepository: PersonneRepository,
    private val personneMapper: PersonneMapper
) {
    @GET
    @Path("/hello")
    @Produces(MediaType.TEXT_PLAIN)
    fun hello() = "Hello RESTEasy Reactive"

    @GET
    @Path("/personne")
    @Produces(MediaType.APPLICATION_JSON)
    fun personne(): Uni<Response> {
        return personneRepository.findAll().list<PersonneEntity>().onItem().transform {
            Response.ok(it.map {
                personneMapper.convertToDTO(it)
            })
        }.onItem().transform(Response.ResponseBuilder::build)
    }
}