package org.oriolbellet.football.adapter.out

import org.oriolbellet.football.domain.team.Team
import org.springframework.data.jpa.repository.JpaRepository
import java.util.*

interface TeamDao: JpaRepository<Team, UUID> {

    fun findByDefaultTrue(): List<Team>

}