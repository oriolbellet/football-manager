package org.oriolbellet.football.adapter.out

import org.oriolbellet.football.application.port.out.FindSeason
import org.oriolbellet.football.application.port.out.SaveSeason
import org.oriolbellet.football.domain.season.Season
import java.util.*
import javax.inject.Inject
import javax.inject.Named

@Named
class SeasonAdapter (@Inject private val seasonDao: SeasonDao) : FindSeason, SaveSeason {

    override fun findSeasonById(seasonId: Long): Optional<Season> {
        return this.seasonDao.findById(seasonId)
    }

    override fun save(season: Season): Season {
        return this.seasonDao.save(season)
    }
}