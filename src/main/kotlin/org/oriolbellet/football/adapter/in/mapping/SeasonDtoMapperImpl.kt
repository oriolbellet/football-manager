package org.oriolbellet.football.adapter.`in`.mapping

import org.oriolbellet.football.adapter.`in`.SeasonDto
import org.oriolbellet.football.domain.season.Season
import javax.inject.Named

@Named
class SeasonDtoMapperImpl : SeasonDtoMapper {

    override fun invoke(input: Season): SeasonDto {
        return SeasonDto(input.seasonId, input.currentWeek)
    }

}