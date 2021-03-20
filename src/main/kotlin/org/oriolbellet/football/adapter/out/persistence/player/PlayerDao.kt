package org.oriolbellet.football.adapter.out.persistence.player

import org.springframework.data.jpa.repository.JpaRepository
import java.util.*

interface PlayerDao: JpaRepository<PlayerDataEntity, UUID>