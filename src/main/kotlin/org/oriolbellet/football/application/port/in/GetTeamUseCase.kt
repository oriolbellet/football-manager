package org.oriolbellet.football.application.port.`in`

import org.oriolbellet.football.domain.team.Team

interface GetTeamUseCase {

    operator fun invoke(teamId: String): Team

}