package org.oriolbellet.football.adapter.`in`.mapping

import org.oriolbellet.football.adapter.`in`.GameDto
import org.oriolbellet.football.domain.game.Game
import javax.inject.Named

@Named
class GameDtoMapperImpl(private val teamDtoMapper: TeamDtoMapper) : GameDtoMapper {

    override fun invoke(input: Game): GameDto {
        return GameDto(input.gameId!!, input.season!!.teams.map { teamDtoMapper(it) })
    }
}