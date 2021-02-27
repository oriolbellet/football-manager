package org.oriolbellet.football.application.port.`in`

import org.oriolbellet.football.domain.team.LineUp
import java.util.*

interface GetLineUpUseCase {

    operator fun invoke(teamId: UUID): LineUp

}