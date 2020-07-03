package org.oriolbellet.football.application.port.`in`

import org.oriolbellet.football.domain.team.Team

interface GetTeamsUseCase {

    operator fun invoke(): List<Team>

}