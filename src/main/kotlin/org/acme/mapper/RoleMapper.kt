package org.acme.mapper

import org.acme.dto.RoleDTO
import org.acme.hibernate.domain.RoleEntity
import org.acme.mapper.config.QuarkusMappingConfig
import org.mapstruct.InheritInverseConfiguration
import org.mapstruct.Mapper
import org.mapstruct.MappingTarget

@Mapper(config = QuarkusMappingConfig::class)
interface RoleMapper {

    @InheritInverseConfiguration
    fun convertToModel(roleDTO: RoleDTO): RoleEntity

    fun convertToDTO(roleEntity: RoleEntity): RoleDTO

    fun toExistingModel(roleDTO: RoleDTO, @MappingTarget roleEntity: RoleEntity)
}
