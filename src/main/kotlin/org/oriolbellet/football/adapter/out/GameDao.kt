package org.oriolbellet.football.adapter.out

import org.oriolbellet.football.domain.game.Game
import org.springframework.data.jpa.repository.JpaRepository
import java.util.*

interface GameDao: JpaRepository<Game, UUID>