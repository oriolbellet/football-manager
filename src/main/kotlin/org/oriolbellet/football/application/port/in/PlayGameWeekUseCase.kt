package org.oriolbellet.football.application.port.`in`

import org.oriolbellet.football.domain.season.gameweek.GameWeek
import java.util.*

interface PlayGameWeekUseCase {

    operator fun invoke(gameId: UUID): GameWeek

}