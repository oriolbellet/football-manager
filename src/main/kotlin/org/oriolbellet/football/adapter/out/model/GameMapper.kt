package org.oriolbellet.football.adapter.out.model

import org.mapstruct.Context
import org.mapstruct.Mapper
import org.oriolbellet.football.domain.game.Game

@Mapper(componentModel = "spring")
interface GameMapper {
    fun toGameDataEntity(game: Game, @Context cycleAvoidingMappingContext: CycleAvoidingMappingContext): GameDataEntity
    fun toGame(dataEntity: GameDataEntity, @Context cycleAvoidingMappingContext: CycleAvoidingMappingContext): Game
}