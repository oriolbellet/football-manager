package org.oriolbellet.football.adapter.`in`.game

import org.oriolbellet.football.adapter.`in`.PlayerDto
import org.oriolbellet.football.adapter.`in`.mapping.PlayerDtoMapper
import org.oriolbellet.football.application.port.`in`.SubstitutionUseCase
import org.springframework.web.bind.annotation.*
import java.util.*

@RestController
@RequestMapping("/football/api/v1/games")
class TeamSubstitutionController(
    private val substitutionUseCase: SubstitutionUseCase,
    private val playerDtoMapper: PlayerDtoMapper
) {

    @PutMapping("/{gameId}/substitution")
    fun substitution(
        @PathVariable("gameId") gameId: UUID,
        @RequestBody substitutionRequestDto: SubstitutionRequestDto
    ): Map<String, List<PlayerDto>> {

        val lineUp = substitutionUseCase(gameId, substitutionRequestDto.player1, substitutionRequestDto.player2)

        val result = LinkedHashMap<String, List<PlayerDto>>()

        result["goalkeeper"] = Collections.singletonList(this.playerDtoMapper(lineUp.getGoalKeeper()))
        result["defender"] = lineUp.getDefenders().map { this.playerDtoMapper(it) }
        result["midfielder"] = lineUp.getMidfielders().map { this.playerDtoMapper(it) }
        result["forward"] = lineUp.getForwards().map { this.playerDtoMapper(it) }
        return result
    }

    data class SubstitutionRequestDto(val player1: String, val player2: String)

}