package org.oriolbellet.football.adapter.`in`.game

import org.oriolbellet.football.adapter.`in`.PlayerDto
import org.oriolbellet.football.adapter.`in`.mapping.LineUpDtoMapper
import org.oriolbellet.football.application.port.`in`.ChangeTacticUseCase
import org.oriolbellet.football.domain.team.BasicTactics
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import java.util.*

@RestController
@RequestMapping("/football/api/v1/games")
class ChangeTacticController(
    private val changeTacticUseCase: ChangeTacticUseCase,
    private val lineUpDtoMapper: LineUpDtoMapper
) {

    @PutMapping("/{gameId}/tactic/{tactic}")
    fun changeTactic(
        @PathVariable("gameId") gameId: UUID,
        @PathVariable("tactic") tactic: BasicTactics
    ): Map<String, List<PlayerDto>> {
        val lineUp = changeTacticUseCase(gameId, tactic)
        return lineUpDtoMapper(lineUp)
    }
}