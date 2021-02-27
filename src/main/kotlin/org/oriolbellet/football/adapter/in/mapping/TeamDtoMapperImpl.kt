package org.oriolbellet.football.adapter.`in`.mapping

import org.oriolbellet.football.adapter.`in`.TeamDto
import org.oriolbellet.football.domain.team.Team
import javax.inject.Named

@Named
class TeamDtoMapperImpl : TeamDtoMapper {

    override fun invoke(input: Team): TeamDto {
        return TeamDto(input.teamId!!, input.name)
    }

}