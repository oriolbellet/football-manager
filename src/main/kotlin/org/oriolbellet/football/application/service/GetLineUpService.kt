package org.oriolbellet.football.application.service

import org.oriolbellet.football.application.port.`in`.GetLineUpUseCase
import org.oriolbellet.football.domain.team.FindTeamDomainService
import org.oriolbellet.football.domain.team.LineUp
import java.util.*
import javax.inject.Named
import javax.transaction.Transactional

@Named
open class GetLineUpService(private val findTeamDomainService: FindTeamDomainService) : GetLineUpUseCase {

    @Transactional
    override fun invoke(teamId: UUID): LineUp {
        return this.findTeamDomainService(teamId).lineUp
    }
}