package org.oriolbellet.football.adapter.out.persistence.game

import org.oriolbellet.football.commons.mapping.CycleAvoidingMappingContextFactory
import org.oriolbellet.football.commons.mapping.MapperWrapper
import org.oriolbellet.football.domain.game.Game
import javax.inject.Named

@Named
class GameMapperWrapper(
    private val gameMapper: GameMapper,
    private val cycleAvoidingMappingContextFactory: CycleAvoidingMappingContextFactory
) :
    MapperWrapper<Game, GameDataEntity> {

    override fun toDomain(data: GameDataEntity): Game {
        return gameMapper.toGame(data, cycleAvoidingMappingContextFactory.create())
    }

    override fun toData(domain: Game): GameDataEntity {
        return gameMapper.toGameDataEntity(domain, cycleAvoidingMappingContextFactory.create())
    }
}