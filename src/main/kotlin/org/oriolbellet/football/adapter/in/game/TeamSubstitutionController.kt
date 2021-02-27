package org.oriolbellet.football.adapter.`in`.game

import org.oriolbellet.football.adapter.`in`.PlayerDto
import org.oriolbellet.football.adapter.`in`.mapping.LineUpDtoMapper
import org.oriolbellet.football.application.port.`in`.SubstitutionUseCase
import org.springframework.web.bind.annotation.*
import java.util.*

@RestController
@RequestMapping("/football/api/v1/games")
class TeamSubstitutionController(
    private val substitutionUseCase: SubstitutionUseCase,
    private val lineUpDtoMapper: LineUpDtoMapper
) {

    @PutMapping("/{gameId}/substitution")
    fun substitution(
        @PathVariable("gameId") gameId: UUID,
        @RequestBody substitutionRequestDto: SubstitutionRequestDto
    ): Map<String, List<PlayerDto>> {

        val lineUp = substitutionUseCase(gameId, substitutionRequestDto.player1, substitutionRequestDto.player2)
        return lineUpDtoMapper(lineUp)
    }

    data class SubstitutionRequestDto(val player1: String, val player2: String)

}