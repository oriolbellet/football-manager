package org.oriolbellet.football.adapter.out.persistence.game

import org.oriolbellet.football.adapter.out.persistence.game.GameDataEntity
import org.springframework.data.jpa.repository.JpaRepository
import java.util.*

interface GameDao: JpaRepository<GameDataEntity, UUID>