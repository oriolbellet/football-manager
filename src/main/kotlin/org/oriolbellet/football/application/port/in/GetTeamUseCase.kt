package org.oriolbellet.football.application.port.`in`

import org.oriolbellet.football.domain.team.Team
import java.util.*

interface GetTeamUseCase {

    operator fun invoke(teamId: UUID): Team

}