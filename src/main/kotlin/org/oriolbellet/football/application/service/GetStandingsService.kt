package org.oriolbellet.football.application.service

import org.oriolbellet.football.application.port.`in`.GetSeasonUseCase
import org.oriolbellet.football.application.port.`in`.GetStandingsUseCase
import org.oriolbellet.football.application.port.out.FindSeason
import org.oriolbellet.football.application.port.out.FindTeams
import org.oriolbellet.football.domain.season.StandingRow
import org.oriolbellet.football.domain.season.StandingsCalculator
import org.oriolbellet.football.error.ErrorCode.SEASON_NOT_FOUND
import org.oriolbellet.football.error.NotFoundException
import javax.inject.Inject
import javax.inject.Named

@Named
class GetStandingsService(@Inject private val findSeason: FindSeason,
                          @Inject private val findTeams: FindTeams,
                          @Inject private val standingsCalculator: StandingsCalculator) : GetStandingsUseCase {

    override fun invoke(): List<StandingRow> {

        val seasonId = 0L

        val season = findSeason.findSeasonById(seasonId).orElseThrow {
            NotFoundException(SEASON_NOT_FOUND, "Season with id $seasonId not found")
        }

        val teams = findTeams.findAll()

        return this.standingsCalculator(teams, season.gameWeeks.subList(0,season.currentWeek))

    }
}