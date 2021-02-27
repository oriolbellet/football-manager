package org.oriolbellet.football.application.port.`in`

import org.oriolbellet.football.domain.game.Game
import java.util.*

interface CreateGameUseCase {

    operator fun invoke(userTeamId: UUID): Game

}