package org.oriolbellet.football.application.service

import org.oriolbellet.football.application.port.`in`.ChangeTacticUseCase
import org.oriolbellet.football.application.port.out.SaveTeam
import org.oriolbellet.football.domain.game.FindGameDomainService
import org.oriolbellet.football.domain.team.BasicTactics
import org.oriolbellet.football.domain.team.LineUp
import java.util.*
import javax.inject.Named
import javax.transaction.Transactional

@Named
open class ChangeTacticService(
    private val findGameDomainService: FindGameDomainService,
    private val saveTeam: SaveTeam
) :
    ChangeTacticUseCase {

    @Transactional
    override fun invoke(gameId: UUID, tactic: BasicTactics): LineUp {
        val game = findGameDomainService(gameId)
        val team = game.userTeam
        team.changeTactic(tactic)
        return saveTeam.save(team).lineUp
    }
}