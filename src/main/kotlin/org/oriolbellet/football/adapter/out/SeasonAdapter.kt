package org.oriolbellet.football.adapter.out

import org.oriolbellet.football.application.port.out.FindSeason
import org.oriolbellet.football.domain.season.Season
import java.util.*
import javax.inject.Inject
import javax.inject.Named

@Named
class SeasonAdapter (@Inject private val seasonDao: SeasonDao) : FindSeason {

    override fun findSeasonById(seasonId: Long): Optional<Season> {
        return this.seasonDao.findById(seasonId)
    }
}