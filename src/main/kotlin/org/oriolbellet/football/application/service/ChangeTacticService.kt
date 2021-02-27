package org.oriolbellet.football.application.service

import org.oriolbellet.football.application.port.`in`.ChangeTacticUseCase
import org.oriolbellet.football.application.port.out.SaveTeam
import org.oriolbellet.football.domain.game.FindGameDomainService
import org.oriolbellet.football.domain.team.BasicTactics
import org.oriolbellet.football.domain.team.LineUp
import org.oriolbellet.football.error.ErrorCode.GAME_NOT_FOUND
import org.oriolbellet.football.error.NotFoundException
import java.util.*
import javax.inject.Named

@Named
class ChangeTacticService(private val findGameDomainService: FindGameDomainService, private val saveTeam: SaveTeam) :
    ChangeTacticUseCase {

    override fun invoke(gameId: UUID, tactic: BasicTactics): LineUp {

        val game = findGameDomainService(gameId)

        val team = game.userTeam ?: throw NotFoundException(GAME_NOT_FOUND, "userTeam for gameid $gameId not found")

        team.changeTactic(tactic)

        return saveTeam.save(team).lineUp

    }

}