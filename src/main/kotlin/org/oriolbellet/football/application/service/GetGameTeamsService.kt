package org.oriolbellet.football.application.service

import org.oriolbellet.football.application.port.`in`.GetGameTeamsUseCase
import org.oriolbellet.football.application.port.out.FindGame
import org.oriolbellet.football.domain.team.Team
import org.oriolbellet.football.error.ErrorCode
import org.oriolbellet.football.error.NotFoundException
import java.util.*
import javax.inject.Named
import javax.transaction.Transactional

@Named
open class GetGameTeamsService(private val findGame: FindGame) : GetGameTeamsUseCase {

    @Transactional
    override fun invoke(gameId: UUID): List<Team> {
        return findGame.find(gameId).orElseThrow {
            NotFoundException(ErrorCode.GAME_NOT_FOUND, "Game with id $gameId not found")
        }.gameTeams
    }
}