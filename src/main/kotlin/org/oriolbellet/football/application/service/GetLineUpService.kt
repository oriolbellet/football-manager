package org.oriolbellet.football.application.service

import org.oriolbellet.football.application.port.`in`.GetLineUpUseCase
import org.oriolbellet.football.domain.team.FindTeamDomainService
import org.oriolbellet.football.domain.team.LineUp
import javax.inject.Named

@Named
class GetLineUpService(private val findTeamDomainService: FindTeamDomainService): GetLineUpUseCase {

    override fun invoke(teamId: String): LineUp {
        return this.findTeamDomainService(teamId).lineUp
    }
}