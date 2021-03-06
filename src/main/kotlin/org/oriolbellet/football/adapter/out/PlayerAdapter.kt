package org.oriolbellet.football.adapter.out

import org.oriolbellet.football.adapter.out.model.CycleAvoidingMappingContext
import org.oriolbellet.football.adapter.out.model.PlayerMapper
import org.oriolbellet.football.application.port.out.FindPlayer
import org.oriolbellet.football.application.port.out.SavePlayer
import org.oriolbellet.football.domain.player.Player
import java.util.*
import javax.inject.Named

@Named
class PlayerAdapter(
    private val playerDao: PlayerDao,
    private val playerMapper: PlayerMapper
) : FindPlayer, SavePlayer {

    override fun find(playerId: UUID): Optional<Player> {
        val findById = playerDao.findById(playerId)
        return if (!findById.isPresent) {
            Optional.empty()
        } else {
            Optional.of(playerMapper.toPlayer(findById.get(), CycleAvoidingMappingContext()))
        }
    }

    override fun save(player: Player): Player {
        val dataEntity = playerMapper.toPlayerDataEntity(player, CycleAvoidingMappingContext())
        return playerMapper.toPlayer(playerDao.save(dataEntity), CycleAvoidingMappingContext())
    }
}