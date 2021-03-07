package org.oriolbellet.football.application.service

import org.oriolbellet.football.application.port.`in`.PlayGameWeekUseCase
import org.oriolbellet.football.application.port.out.FindGame
import org.oriolbellet.football.application.port.out.SaveGame
import org.oriolbellet.football.domain.match.MatchAlgorithm
import org.oriolbellet.football.domain.season.GameWeek
import org.oriolbellet.football.error.ErrorCode
import org.oriolbellet.football.error.NotFoundException
import java.util.*
import javax.inject.Named
import javax.transaction.Transactional

@Named
open class PlayGameWeekService(
    private val findGame: FindGame,
    private val saveGame: SaveGame,
    private val matchAlgorithm: MatchAlgorithm
) : PlayGameWeekUseCase {

    @Transactional
    override fun invoke(gameId: UUID): GameWeek {

        val game = findGame.find(gameId).orElseThrow {
            NotFoundException(ErrorCode.GAME_NOT_FOUND, "Game with id $gameId not found")
        }

        game.play(matchAlgorithm)

        saveGame.save(game)

        return game.lastGameWeek()

    }
}