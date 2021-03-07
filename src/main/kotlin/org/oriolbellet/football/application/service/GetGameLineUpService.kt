package org.oriolbellet.football.application.service

import org.oriolbellet.football.application.port.`in`.GetGameLineUpUseCase
import org.oriolbellet.football.application.port.out.FindGame
import org.oriolbellet.football.domain.team.LineUp
import org.oriolbellet.football.error.ErrorCode.GAME_NOT_FOUND
import org.oriolbellet.football.error.NotFoundException
import java.util.*
import javax.inject.Named
import javax.transaction.Transactional

@Named
open class GetGameLineUpService(private val findGame: FindGame) : GetGameLineUpUseCase {

    @Transactional
    override fun invoke(gameId: UUID): LineUp {
        val game = findGame.find(gameId).orElseThrow {
            NotFoundException(GAME_NOT_FOUND, "Game with id $gameId not found")
        }
        return game.userTeam.lineUp
    }
}