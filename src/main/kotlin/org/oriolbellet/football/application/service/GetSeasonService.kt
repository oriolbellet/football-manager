package org.oriolbellet.football.application.service

import org.oriolbellet.football.application.port.`in`.GetSeasonUseCase
import org.oriolbellet.football.application.port.out.FindSeason
import org.oriolbellet.football.domain.season.Season
import org.oriolbellet.football.error.ErrorCode.SEASON_NOT_FOUND
import org.oriolbellet.football.error.NotFoundException
import javax.inject.Inject
import javax.inject.Named

@Named
class GetSeasonService(@Inject private val findSeason: FindSeason) : GetSeasonUseCase {

    override fun invoke(): Season {

        val seasonId = 0L

        return findSeason.findSeasonById(seasonId).orElseThrow {
            NotFoundException(SEASON_NOT_FOUND, "Season with id $seasonId not found")
        }

    }
}