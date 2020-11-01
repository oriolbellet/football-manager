package org.oriolbellet.football.application.service

import org.oriolbellet.football.application.port.`in`.PlayGameWeekUseCase
import org.oriolbellet.football.application.port.`in`.PlayMatchUseCase
import org.oriolbellet.football.application.port.out.FindSeason
import org.oriolbellet.football.application.port.out.SaveSeason
import org.oriolbellet.football.domain.match.MatchPlayer
import org.oriolbellet.football.domain.season.GameWeek
import org.oriolbellet.football.error.ErrorCode.SEASON_NOT_FOUND
import org.oriolbellet.football.error.NotFoundException
import javax.inject.Named

@Named
class PlayGameWeekService(private val findSeason: FindSeason,
                          private val saveSeason: SaveSeason,
                          private val matchPlayer: MatchPlayer): PlayGameWeekUseCase {

    override fun invoke(): GameWeek {

        val seasonId = 0L

        val season = findSeason.findSeasonById(seasonId).orElseThrow {
            NotFoundException(SEASON_NOT_FOUND, "Season with id $seasonId not found")
        }

        season.playCurrentWeek(matchPlayer)

        this.saveSeason.save(season)

        return season.gameWeeks[season.currentWeek-1]

    }
}