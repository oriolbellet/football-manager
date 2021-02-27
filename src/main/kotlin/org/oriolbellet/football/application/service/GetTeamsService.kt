package org.oriolbellet.football.application.service

import org.oriolbellet.football.application.port.`in`.GetTeamsUseCase
import org.oriolbellet.football.application.port.out.FindTeams
import org.oriolbellet.football.domain.team.Team
import javax.inject.Named

@Named
class GetTeamsService(private val findTeams: FindTeams): GetTeamsUseCase {

    override fun invoke(): List<Team> {
        return this.findTeams.findAllDefaultTeams()
    }

}