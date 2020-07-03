package org.oriolbellet.football.adapter.`in`.mapping

import org.oriolbellet.football.adapter.`in`.PlayerDto
import org.oriolbellet.football.adapter.`in`.mapping.PlayerDtoMapper
import org.oriolbellet.football.domain.player.Player
import javax.inject.Named

@Named
class PlayerDtoMapperImpl : PlayerDtoMapper {

    override fun invoke(input: Player): PlayerDto {
        return PlayerDto(input.playerId, input.name, input.average)
    }

}