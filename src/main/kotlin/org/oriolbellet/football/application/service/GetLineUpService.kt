package org.oriolbellet.football.application.service

import org.oriolbellet.football.application.port.`in`.GetLineUpUseCase
import org.oriolbellet.football.application.port.out.FindLineup
import org.oriolbellet.football.domain.team.LineUp
import javax.inject.Named

@Named
class GetLineUpService(private val findLineup: FindLineup): GetLineUpUseCase {

    override fun invoke(teamId: String): LineUp {
        return this.findLineup.findLineupById(teamId)
    }
}