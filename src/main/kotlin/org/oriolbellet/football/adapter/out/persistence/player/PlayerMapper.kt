package org.oriolbellet.football.adapter.out.persistence.player

import org.mapstruct.Context
import org.mapstruct.Mapper
import org.oriolbellet.football.commons.mapping.CycleAvoidingMappingContextImpl
import org.oriolbellet.football.domain.player.Player

@Mapper(componentModel = "spring")
interface PlayerMapper {
    fun toPlayerDataEntity(player: Player, @Context cycleAvoidingMappingContextImpl: CycleAvoidingMappingContextImpl): PlayerDataEntity
    fun toPlayer(dataEntity: PlayerDataEntity, @Context cycleAvoidingMappingContextImpl: CycleAvoidingMappingContextImpl): Player
}