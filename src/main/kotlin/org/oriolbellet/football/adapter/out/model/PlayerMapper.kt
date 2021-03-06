package org.oriolbellet.football.adapter.out.model

import org.mapstruct.Context
import org.mapstruct.Mapper
import org.oriolbellet.football.domain.game.Game
import org.oriolbellet.football.domain.player.Player

@Mapper(componentModel = "spring")
interface PlayerMapper {
    fun toPlayerDataEntity(player: Player, @Context cycleAvoidingMappingContext: CycleAvoidingMappingContext): PlayerDataEntity
    fun toPlayer(dataEntity: PlayerDataEntity, @Context cycleAvoidingMappingContext: CycleAvoidingMappingContext): Player
}