package org.oriolbellet.football.domain.game

import org.oriolbellet.football.application.port.out.FindGame
import org.oriolbellet.football.error.ErrorCode
import org.oriolbellet.football.error.NotFoundException
import java.util.*
import javax.inject.Named

@Named
class FindGameDomainServiceImpl(private val findGame: FindGame) : FindGameDomainService {

    override fun invoke(gameId: UUID): Game {
        return findGame.find(gameId).orElseThrow {
            NotFoundException(ErrorCode.GAME_NOT_FOUND, "Game with id $gameId not found")
        }
    }
}