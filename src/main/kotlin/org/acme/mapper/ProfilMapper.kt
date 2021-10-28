package org.acme.mapper

import org.acme.dto.ProfilDTO
import org.acme.hibernate.domain.ProfilEntity
import org.acme.mapper.config.QuarkusMappingConfig
import org.mapstruct.InheritInverseConfiguration
import org.mapstruct.Mapper
import org.mapstruct.MappingTarget

@Mapper(config = QuarkusMappingConfig::class)
interface ProfilMapper {

    @InheritInverseConfiguration
    fun convertToModel(profilDTO: ProfilDTO): ProfilEntity

    fun convertToDTO(profilEntity: ProfilEntity): ProfilDTO

    fun toExistingModel(profilDTO: ProfilDTO, @MappingTarget profilEntity: ProfilEntity)
}
