package org.acme.mapper

import org.acme.dto.DepartementDTO
import org.acme.mapper.config.QuarkusMappingConfig
import org.acme.hibernate.domain.DepartementAnnuaireEntity
import org.mapstruct.InheritInverseConfiguration
import org.mapstruct.Mapper
import org.mapstruct.MappingTarget

@Mapper(config = QuarkusMappingConfig::class)
interface DepartementMapper {

    @InheritInverseConfiguration
    fun convertToModel(departementDTO: DepartementDTO): DepartementAnnuaireEntity

    fun convertToDTO(departementAnnuaireEntity: DepartementAnnuaireEntity): DepartementDTO

    fun toExistingModel(departementDTO: DepartementDTO, @MappingTarget departementAnnuaireEntity: DepartementAnnuaireEntity): DepartementAnnuaireEntity
}
