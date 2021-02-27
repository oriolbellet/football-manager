package org.oriolbellet.football.application.port.`in`

import org.oriolbellet.football.domain.team.Team
import java.util.*

interface GetGameTeamsUseCase {

    operator fun invoke(gameId: UUID): List<Team>

}