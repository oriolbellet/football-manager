package org.oriolbellet.football.adapter.out

import org.oriolbellet.football.domain.match.Match
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface MatchDao: JpaRepository<Match, Long> {
}