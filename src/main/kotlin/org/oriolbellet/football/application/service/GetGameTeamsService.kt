package org.oriolbellet.football.application.service

import org.oriolbellet.football.application.port.`in`.GetGameTeamsUseCase
import org.oriolbellet.football.application.port.out.FindGame
import org.oriolbellet.football.domain.team.Team
import org.oriolbellet.football.error.ErrorCode
import org.oriolbellet.football.error.NotFoundException
import java.util.*
import javax.inject.Named

@Named
class GetGameTeamsService(private val findGame: FindGame): GetGameTeamsUseCase {

    override fun invoke(gameId: UUID): List<Team> {

        val game = findGame.find(gameId).orElseThrow {
            NotFoundException(ErrorCode.GAME_NOT_FOUND, "Game with id $gameId not found")
        }

        return game.gameTeams

    }
}