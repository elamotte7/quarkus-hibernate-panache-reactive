package org.acme.common.rest.pagination

import javax.validation.constraints.Positive
import javax.validation.constraints.PositiveOrZero
import javax.ws.rs.DefaultValue
import javax.ws.rs.QueryParam

data class PaginationListeRequest(
    @field:QueryParam("query")
    @field:DefaultValue("")
    val query: String = "",

    @field:QueryParam("sort")
    @field:DefaultValue("")
    val sort: String = "",

    @field:QueryParam("page")
    @field:DefaultValue("0")
    @field:PositiveOrZero
    val page: Int = 0,

    @field:QueryParam("size")
    @field:DefaultValue("10")
    @field:Positive
    val size: Int = 0
)
