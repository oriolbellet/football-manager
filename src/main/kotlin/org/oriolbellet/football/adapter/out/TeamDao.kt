package org.oriolbellet.football.adapter.out

import org.oriolbellet.football.adapter.out.model.TeamDataEntity
import org.oriolbellet.football.domain.team.Team
import org.springframework.data.jpa.repository.JpaRepository
import java.util.*

interface TeamDao: JpaRepository<TeamDataEntity, UUID> {

    fun findByDefTrue(): List<TeamDataEntity>

}