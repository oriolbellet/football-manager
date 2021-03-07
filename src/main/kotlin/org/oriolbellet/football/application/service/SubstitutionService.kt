package org.oriolbellet.football.application.service

import org.oriolbellet.football.application.port.`in`.SubstitutionUseCase
import org.oriolbellet.football.application.port.out.SaveTeam
import org.oriolbellet.football.domain.game.FindGameDomainService
import org.oriolbellet.football.domain.player.FindPlayerDomainService
import org.oriolbellet.football.domain.team.LineUp
import java.util.*
import javax.inject.Named
import javax.transaction.Transactional

@Named
open class SubstitutionService(
    private val findGameDomainService: FindGameDomainService,
    private val findPlayerDomainService: FindPlayerDomainService,
    private val saveTeam: SaveTeam
) : SubstitutionUseCase {

    @Transactional
    override fun invoke(gameId: UUID, player1Id: UUID, player2Id: UUID): LineUp {

        val team = findGameDomainService(gameId).userTeam

        team.substitution(findPlayerDomainService(player1Id), findPlayerDomainService(player2Id))

        return saveTeam.save(team).lineUp
    }
}