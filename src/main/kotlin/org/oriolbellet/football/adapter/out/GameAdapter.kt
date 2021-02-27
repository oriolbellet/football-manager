package org.oriolbellet.football.adapter.out

import org.oriolbellet.football.application.port.out.FindGame
import org.oriolbellet.football.application.port.out.SaveGame
import org.oriolbellet.football.domain.game.Game
import java.util.*
import javax.inject.Named

@Named
class GameAdapter(private val gameDao: GameDao) : SaveGame, FindGame {

    override fun save(game: Game): Game {
        return gameDao.save(game)
    }

    override fun find(gameId: UUID): Optional<Game> {
        return gameDao.findById(gameId)
    }

}