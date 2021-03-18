package org.oriolbellet.football.adapter.out.persistence.team

import org.mapstruct.Context
import org.mapstruct.Mapper
import org.oriolbellet.football.commons.mapping.CycleAvoidingMappingContextImpl
import org.oriolbellet.football.domain.team.Team

@Mapper(componentModel = "spring")
interface TeamMapper {
    fun toTeamDataEntity(team: Team, @Context cycleAvoidingMappingContextImpl: CycleAvoidingMappingContextImpl): TeamDataEntity
    fun toTeam(dataEntity: TeamDataEntity, @Context cycleAvoidingMappingContextImpl: CycleAvoidingMappingContextImpl): Team
}