package org.oriolbellet.football.adapter.`in`.mapping

import org.oriolbellet.football.adapter.`in`.SeasonDto
import org.oriolbellet.football.adapter.`in`.TeamDto
import org.oriolbellet.football.domain.season.Season
import org.oriolbellet.football.domain.team.Team
import javax.inject.Named

@Named
class SeasonDtoMapperImpl : SeasonDtoMapper {

    override fun invoke(season: Season): SeasonDto {
        return SeasonDto(season.seasonId, season.currentWeek)
    }

}