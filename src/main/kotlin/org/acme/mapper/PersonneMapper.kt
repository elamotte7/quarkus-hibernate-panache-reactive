package org.acme.mapper

import org.acme.dto.PersonneDTO
import org.acme.hibernate.domain.PersonneEntity
import org.acme.mapper.config.QuarkusMappingConfig
import org.mapstruct.InheritInverseConfiguration
import org.mapstruct.Mapper
import org.mapstruct.MappingTarget

@Mapper(config = QuarkusMappingConfig::class)
interface PersonneMapper {

    @InheritInverseConfiguration
    fun convertToModel(personDto: PersonneDTO): PersonneEntity

    fun convertToDTO(personEntity: PersonneEntity): PersonneDTO

    fun toExistingModel(personDto: PersonneDTO, @MappingTarget personeEntity: PersonneEntity)

}
