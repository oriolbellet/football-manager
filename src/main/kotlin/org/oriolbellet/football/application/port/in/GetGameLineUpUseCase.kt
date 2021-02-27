package org.oriolbellet.football.application.port.`in`

import org.oriolbellet.football.domain.team.LineUp
import java.util.*

interface GetGameLineUpUseCase {

    operator fun invoke(gameId: UUID): LineUp

}