package org.oriolbellet.football.application.port.`in`

import org.oriolbellet.football.domain.match.Match
import java.util.*

interface CreateMatchUseCase {

    operator fun invoke(homeTeamId: UUID, awayTeamId: UUID): Match

}