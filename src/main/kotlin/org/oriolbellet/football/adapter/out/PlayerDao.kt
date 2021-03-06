package org.oriolbellet.football.adapter.out

import org.oriolbellet.football.adapter.out.model.PlayerDataEntity
import org.oriolbellet.football.domain.player.Player
import org.springframework.data.jpa.repository.JpaRepository
import java.util.*

interface PlayerDao: JpaRepository<PlayerDataEntity, UUID>