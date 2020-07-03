package org.oriolbellet.football.adapter.out

import org.oriolbellet.football.domain.team.Team
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface TeamDao: JpaRepository<Team, String> {
}