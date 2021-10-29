package org.acme

import io.quarkus.test.junit.QuarkusTest
import io.restassured.RestAssured.given
import io.restassured.common.mapper.TypeRef
import io.restassured.response.Response
import org.acme.common.rest.model.dto.ResponseListDTO
import org.acme.dto.PersonneDTO
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertNull
import org.junit.jupiter.api.Order
import org.junit.jupiter.api.Test

@QuarkusTest
class PersonneReactiveResourceTest {
    @Test
    fun testListAllPersonnes() {
        //List all, should have all 3 fruits the database has initially:
        val response = given()
            .`when`()
            .get("/personnes")
            .andReturn()

        val responseListDTO: ResponseListDTO<PersonneDTO>? = response
            .then().statusCode(javax.ws.rs.core.Response.Status.OK.statusCode)
            .extract().`as`(object : TypeRef<ResponseListDTO<PersonneDTO>>() {})
        assertEquals(3, responseListDTO?.totalResultCount)
    }

    @Test
    @Order(3)
    fun testCherchePersonneParId() {
        val response: Response = given()
            .`when`()
            .get("/personnes/1")
            .andReturn()

        val personneDTO = response
            .then().statusCode(javax.ws.rs.core.Response.Status.OK.statusCode).extract().`as`(PersonneDTO::class.java)
        assertEquals("IDN00010006I", personneDTO.uid)
        assertNull(personneDTO.prenom)
        assertNull(personneDTO.nomUsuel)
        assertNull(personneDTO.sexe)
        assertNull(personneDTO.jpegPhoto)
        assertEquals(2, personneDTO.profils?.size)
    }
}