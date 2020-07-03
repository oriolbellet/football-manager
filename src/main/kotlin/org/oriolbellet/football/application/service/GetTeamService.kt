package org.oriolbellet.football.application.service

import org.oriolbellet.football.application.port.`in`.GetTeamUseCase
import org.oriolbellet.football.domain.team.FindTeamDomainService
import org.oriolbellet.football.domain.team.Team
import javax.inject.Named

@Named
class GetTeamService(private val findTeamDomainService: FindTeamDomainService): GetTeamUseCase {

    override fun invoke(teamId: String): Team {
       return this.findTeamDomainService(teamId)
    }

}