package org.oriolbellet.football.adapter.out.persistence.game

import org.mapstruct.Context
import org.mapstruct.Mapper
import org.oriolbellet.football.commons.mapping.CycleAvoidingMappingContext
import org.oriolbellet.football.domain.game.Game

@Mapper(componentModel = "spring")
interface GameMapper {
    fun toGameDataEntity(game: Game, @Context cycleAvoidingMappingContext: CycleAvoidingMappingContext): GameDataEntity
    fun toGame(dataEntity: GameDataEntity, @Context cycleAvoidingMappingContext: CycleAvoidingMappingContext): Game
}