package org.oriolbellet.football.adapter.out

import org.oriolbellet.football.adapter.out.model.GameDataEntity
import org.springframework.data.jpa.repository.JpaRepository
import java.util.*

interface GameDao: JpaRepository<GameDataEntity, UUID>