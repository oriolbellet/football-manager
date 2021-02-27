package org.oriolbellet.football.adapter.out

import org.oriolbellet.football.domain.player.Player
import org.springframework.data.jpa.repository.JpaRepository

interface PlayerDao: JpaRepository<Player, String>