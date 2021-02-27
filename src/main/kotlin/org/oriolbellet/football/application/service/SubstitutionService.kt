package org.oriolbellet.football.application.service

import org.oriolbellet.football.application.port.`in`.SubstitutionUseCase
import org.oriolbellet.football.application.port.out.SaveTeam
import org.oriolbellet.football.domain.game.FindGameDomainService
import org.oriolbellet.football.domain.player.FindPlayerDomainService
import org.oriolbellet.football.domain.team.LineUp
import org.oriolbellet.football.error.ErrorCode.PLAYER_NOT_FOUND
import org.oriolbellet.football.error.NotFoundException
import java.util.*
import javax.inject.Named

@Named
class SubstitutionService(
    private val findGameDomainService: FindGameDomainService,
    private val findPlayerDomainService: FindPlayerDomainService,
    private val saveTeam: SaveTeam
) : SubstitutionUseCase {

    override fun invoke(gameId: UUID, player1Id: String, player2Id: String): LineUp {

        val team = findGameDomainService(gameId).userTeam ?: throw NotFoundException(
            PLAYER_NOT_FOUND,
            "userTeam for gameid $gameId not found"
        )

        team.substitution(findPlayerDomainService(player1Id), findPlayerDomainService(player2Id))

        return saveTeam.save(team).lineUp

    }
}