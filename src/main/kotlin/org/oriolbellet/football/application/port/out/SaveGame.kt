package org.oriolbellet.football.application.port.out

import org.oriolbellet.football.domain.game.Game

interface SaveGame {
    fun save(game: Game): Game
}