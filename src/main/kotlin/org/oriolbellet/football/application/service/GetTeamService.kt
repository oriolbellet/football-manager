package org.oriolbellet.football.application.service

import org.oriolbellet.football.application.port.`in`.GetTeamUseCase
import org.oriolbellet.football.domain.team.FindTeamDomainService
import org.oriolbellet.football.domain.team.Team
import java.util.*
import javax.inject.Named
import javax.transaction.Transactional

@Named
open class GetTeamService(private val findTeamDomainService: FindTeamDomainService) : GetTeamUseCase {

    @Transactional
    override fun invoke(teamId: UUID): Team {
        return this.findTeamDomainService(teamId)
    }
}