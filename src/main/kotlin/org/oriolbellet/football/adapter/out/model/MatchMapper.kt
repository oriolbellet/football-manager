package org.oriolbellet.football.adapter.out.model

import org.mapstruct.Context
import org.mapstruct.Mapper
import org.oriolbellet.football.domain.game.Game
import org.oriolbellet.football.domain.match.Match

@Mapper(componentModel = "spring")
interface MatchMapper {
    fun toMatchDataEntity(match: Match, @Context cycleAvoidingMappingContext: CycleAvoidingMappingContext): MatchDataEntity
    fun toMatch(dataEntity: MatchDataEntity, @Context cycleAvoidingMappingContext: CycleAvoidingMappingContext): Match
}