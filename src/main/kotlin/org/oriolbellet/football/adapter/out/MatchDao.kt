package org.oriolbellet.football.adapter.out

import org.oriolbellet.football.domain.match.Match
import org.springframework.data.jpa.repository.JpaRepository

interface MatchDao: JpaRepository<Match, Long>