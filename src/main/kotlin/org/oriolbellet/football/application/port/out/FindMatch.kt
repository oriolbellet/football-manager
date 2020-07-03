package org.oriolbellet.football.application.port.out

import org.oriolbellet.football.domain.match.Match
import java.util.*

interface FindMatch {

    fun findMatchById(matchId: Long): Optional<Match>

}
