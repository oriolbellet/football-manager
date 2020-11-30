package org.oriolbellet.football.adapter.`in`.mapping

import org.oriolbellet.football.adapter.`in`.ScoreDto
import org.oriolbellet.football.domain.match.Score
import javax.inject.Named

@Named
class ScoreDtoMapperImpl : ScoreDtoMapper {

    override fun invoke(input: Score): ScoreDto {

        return ScoreDto(input.homeTeamGoals, input.awayTeamGoals)

    }
}