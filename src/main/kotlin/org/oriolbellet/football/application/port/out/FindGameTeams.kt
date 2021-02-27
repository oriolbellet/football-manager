package org.oriolbellet.football.application.port.out

import org.oriolbellet.football.domain.game.Game
import java.util.*

interface FindGame {
    fun find(gameId: UUID): Optional<Game>
}