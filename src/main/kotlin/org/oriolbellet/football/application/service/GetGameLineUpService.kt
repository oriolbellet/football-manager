package org.oriolbellet.football.application.service

import org.oriolbellet.football.application.port.`in`.GetGameLineUpUseCase
import org.oriolbellet.football.application.port.`in`.GetLineUpUseCase
import org.oriolbellet.football.application.port.out.FindGame
import org.oriolbellet.football.domain.team.FindTeamDomainService
import org.oriolbellet.football.domain.team.LineUp
import org.oriolbellet.football.error.ErrorCode
import org.oriolbellet.football.error.ErrorCode.GAME_NOT_FOUND
import org.oriolbellet.football.error.NotFoundException
import java.util.*
import javax.inject.Named

@Named
class GetGameLineUpService(private val findGame: FindGame) : GetGameLineUpUseCase {

    override fun invoke(gameId: UUID): LineUp {
        val game = findGame.find(gameId).orElseThrow {
            NotFoundException(GAME_NOT_FOUND, "Game with id $gameId not found")
        }
        return game.userTeam!!.lineUp
    }
}