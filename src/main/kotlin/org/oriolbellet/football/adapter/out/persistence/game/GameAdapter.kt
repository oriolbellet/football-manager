package org.oriolbellet.football.adapter.out.persistence.game

import org.oriolbellet.football.application.port.out.FindGame
import org.oriolbellet.football.application.port.out.SaveGame
import org.oriolbellet.football.commons.mapping.MapperWrapper
import org.oriolbellet.football.domain.game.Game
import java.util.*
import javax.inject.Named

@Named
class GameAdapter(
    private val gameDao: GameDao,
    private val mapperWrapper: MapperWrapper<Game, GameDataEntity>,
) : SaveGame, FindGame {

    override fun save(game: Game): Game {
        val gameDataEntity = mapperWrapper.toData(game)
        val created = gameDao.save(gameDataEntity)
        return mapperWrapper.toDomain(created)
    }

    override fun find(gameId: UUID): Optional<Game> {
        val findById = gameDao.findById(gameId)
        return if (!findById.isPresent) {
            Optional.empty()
        } else {
            Optional.of(mapperWrapper.toDomain(findById.get()))
        }
    }
}