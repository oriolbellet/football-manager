package org.oriolbellet.football.application.service

import org.oriolbellet.football.application.port.`in`.GetSquadUseCase
import org.oriolbellet.football.domain.player.Player
import org.oriolbellet.football.domain.team.FindTeamDomainService
import javax.inject.Named

@Named
class GetSquadService(private val findTeamById: FindTeamDomainService): GetSquadUseCase {

    override fun invoke(teamId: String): List<Player> {

        return this.findTeamById(teamId).squad

    }

}