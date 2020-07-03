package org.oriolbellet.football.adapter.out

import org.oriolbellet.football.domain.player.Player
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface PlayerDao: JpaRepository<Player, String> {
}