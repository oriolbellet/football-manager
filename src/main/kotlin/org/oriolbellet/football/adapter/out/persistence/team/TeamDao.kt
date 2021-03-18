package org.oriolbellet.football.adapter.out.persistence.team

import org.springframework.data.jpa.repository.JpaRepository
import java.util.*

interface TeamDao: JpaRepository<TeamDataEntity, UUID> {

    fun findByDefTrue(): List<TeamDataEntity>

}