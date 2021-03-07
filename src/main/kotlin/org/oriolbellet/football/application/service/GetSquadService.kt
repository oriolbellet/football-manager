package org.oriolbellet.football.application.service

import org.oriolbellet.football.application.port.`in`.GetSquadUseCase
import org.oriolbellet.football.domain.player.Player
import org.oriolbellet.football.domain.team.FindTeamDomainService
import java.util.*
import javax.inject.Named
import javax.transaction.Transactional

@Named
open class GetSquadService(private val findTeamById: FindTeamDomainService): GetSquadUseCase {

    @Transactional
    override fun invoke(teamId: UUID): List<Player> {
        return this.findTeamById(teamId).squad
    }
}