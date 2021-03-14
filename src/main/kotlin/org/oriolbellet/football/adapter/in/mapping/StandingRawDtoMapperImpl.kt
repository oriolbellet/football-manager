package org.oriolbellet.football.adapter.`in`.mapping

import org.oriolbellet.football.adapter.`in`.StandingRowDto
import org.oriolbellet.football.domain.season.standings.StandingRow
import javax.inject.Named

@Named
class StandingRawDtoMapperImpl: StandingRawDtoMapper {

    override fun invoke(input: StandingRow): StandingRowDto {
        return StandingRowDto(input.team.name, input.standingData.points, input.standingData.goalsFor, input.standingData.goalsAgainst)
    }
}