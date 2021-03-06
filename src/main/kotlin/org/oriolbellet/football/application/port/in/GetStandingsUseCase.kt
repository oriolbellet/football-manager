package org.oriolbellet.football.application.port.`in`

import org.oriolbellet.football.domain.season.standings.StandingRow
import java.util.*

interface GetStandingsUseCase {

    operator fun invoke(gameId: UUID): List<StandingRow>

}