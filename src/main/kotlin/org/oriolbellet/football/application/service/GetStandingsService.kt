package org.oriolbellet.football.application.service

import org.oriolbellet.football.application.port.`in`.GetStandingsUseCase
import org.oriolbellet.football.application.port.out.FindGame
import org.oriolbellet.football.domain.season.StandingRow
import org.oriolbellet.football.domain.season.StandingsCalculator
import org.oriolbellet.football.error.ErrorCode
import org.oriolbellet.football.error.NotFoundException
import java.util.*
import javax.inject.Named
import javax.transaction.Transactional

@Named
open class GetStandingsService(
    private val findGame: FindGame,
    private val standingsCalculator: StandingsCalculator
) : GetStandingsUseCase {

    @Transactional
    override fun invoke(gameId: UUID): List<StandingRow> {

        val game = findGame.find(gameId).orElseThrow {
            NotFoundException(ErrorCode.GAME_NOT_FOUND, "Game with id $gameId not found")
        }

        return this.standingsCalculator(game.gameTeams, game.gameWeeksFromFirstToLastPlayed())

    }
}