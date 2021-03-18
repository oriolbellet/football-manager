package org.oriolbellet.football.adapter.out.persistence.match

import org.springframework.data.jpa.repository.JpaRepository

interface MatchDao: JpaRepository<MatchDataEntity, Long>