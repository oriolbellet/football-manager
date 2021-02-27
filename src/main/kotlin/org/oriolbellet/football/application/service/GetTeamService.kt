package org.oriolbellet.football.application.service

import org.oriolbellet.football.application.port.`in`.GetTeamUseCase
import org.oriolbellet.football.domain.team.FindTeamDomainService
import org.oriolbellet.football.domain.team.Team
import java.util.*
import javax.inject.Named

@Named
class GetTeamService(private val findTeamDomainService: FindTeamDomainService): GetTeamUseCase {

    override fun invoke(teamId: UUID): Team {
       return this.findTeamDomainService(teamId)
    }

}