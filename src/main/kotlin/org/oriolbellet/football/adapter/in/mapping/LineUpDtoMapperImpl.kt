package org.oriolbellet.football.adapter.`in`.mapping

import org.oriolbellet.football.adapter.`in`.PlayerDto
import org.oriolbellet.football.domain.team.LineUp
import java.util.*
import javax.inject.Named

@Named
class LineUpDtoMapperImpl(private val playerDtoMapper: PlayerDtoMapper) : LineUpDtoMapper {

    override fun invoke(input: LineUp): Map<String, List<PlayerDto>> {

        val result = LinkedHashMap<String, List<PlayerDto>>()

        result["goalkeeper"] = Collections.singletonList(this.playerDtoMapper(input.goalKeeper()))
        result["defender"] = input.defenders().map { this.playerDtoMapper(it) }
        result["midfielder"] = input.midfielders().map { this.playerDtoMapper(it) }
        result["forward"] = input.forwards().map { this.playerDtoMapper(it) }

        return result

    }

}