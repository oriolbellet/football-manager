package org.oriolbellet.football.adapter.out.model

import org.mapstruct.Context
import org.mapstruct.Mapper
import org.oriolbellet.football.domain.team.Team

@Mapper(componentModel = "spring")
interface TeamMapper {
    fun toTeamDataEntity(team: Team, @Context cycleAvoidingMappingContext: CycleAvoidingMappingContext): TeamDataEntity
    fun toTeam(dataEntity: TeamDataEntity, @Context cycleAvoidingMappingContext: CycleAvoidingMappingContext): Team
}