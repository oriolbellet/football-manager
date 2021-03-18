package org.oriolbellet.football.adapter.out.persistence.player

import org.oriolbellet.football.commons.mapping.CycleAvoidingMappingContextImpl
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
            Optional.of(playerMapper.toPlayer(findById.get(), CycleAvoidingMappingContextImpl()))
        }
    }

    override fun save(player: Player): Player {
        val dataEntity = playerMapper.toPlayerDataEntity(player, CycleAvoidingMappingContextImpl())
        return playerMapper.toPlayer(playerDao.save(dataEntity), CycleAvoidingMappingContextImpl())
    }
}