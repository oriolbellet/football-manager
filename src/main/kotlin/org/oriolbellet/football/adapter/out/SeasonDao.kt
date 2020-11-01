package org.oriolbellet.football.adapter.out

import org.oriolbellet.football.domain.season.Season
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface SeasonDao: JpaRepository<Season, Long> {
}