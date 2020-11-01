package org.oriolbellet.football.application.port.out

import org.oriolbellet.football.domain.season.Season
import java.util.*

interface FindSeason {

    fun findSeasonById(seasonId: Long): Optional<Season>

}
