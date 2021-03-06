package org.oriolbellet.football.adapter.out

import org.oriolbellet.football.adapter.out.model.CycleAvoidingMappingContext
import org.oriolbellet.football.adapter.out.model.GameMapper
import org.oriolbellet.football.application.port.out.FindGame
import org.oriolbellet.football.application.port.out.SaveGame
import org.oriolbellet.football.domain.game.Game
import java.util.*
import javax.inject.Named

@Named
class GameAdapter(
    private val gameDao: GameDao,
    private val gameMapper: GameMapper,
) : SaveGame, FindGame {

    override fun save(game: Game): Game {
        val gameDataEntity = gameMapper.toGameDataEntity(game, CycleAvoidingMappingContext())
        return gameMapper.toGame(gameDao.save(gameDataEntity), CycleAvoidingMappingContext())
    }

    override fun find(gameId: UUID): Optional<Game> {
        val findById = gameDao.findById(gameId)
        return if (!findById.isPresent) {
            Optional.empty()
        } else {
            Optional.of(gameMapper.toGame(findById.get(), CycleAvoidingMappingContext()))
        }
    }
}