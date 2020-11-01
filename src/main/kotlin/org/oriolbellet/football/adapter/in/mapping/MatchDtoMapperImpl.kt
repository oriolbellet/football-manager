package org.oriolbellet.football.adapter.`in`.mapping

import org.oriolbellet.football.adapter.`in`.MatchDto
import org.oriolbellet.football.domain.match.Match
import javax.inject.Inject
import javax.inject.Named

@Named
class MatchDtoMapperImpl(@Inject private val scoreDtoMapper: ScoreDtoMapper) : MatchDtoMapper {

    override fun invoke(input: Match): MatchDto {

        return MatchDto(input.matchId,
                input.homeTeam.name,
                input.awayTeam.name,
                if (input.score != null) this.scoreDtoMapper(input.score!!) else null)

    }

}