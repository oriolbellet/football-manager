package org.oriolbellet.football.adapter.out.persistence.match

import org.mapstruct.Context
import org.mapstruct.Mapper
import org.oriolbellet.football.commons.mapping.CycleAvoidingMappingContextImpl
import org.oriolbellet.football.domain.match.Match

@Mapper(componentModel = "spring")
interface MatchMapper {
    fun toMatchDataEntity(match: Match, @Context cycleAvoidingMappingContextImpl: CycleAvoidingMappingContextImpl): MatchDataEntity
    fun toMatch(dataEntity: MatchDataEntity, @Context cycleAvoidingMappingContextImpl: CycleAvoidingMappingContextImpl): Match
}