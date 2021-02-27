package org.oriolbellet.football.adapter.`in`.game

import org.oriolbellet.football.adapter.`in`.PlayerDto
import org.oriolbellet.football.adapter.`in`.mapping.LineUpDtoMapper
import org.oriolbellet.football.application.port.`in`.GetGameLineUpUseCase
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import java.util.*

@RestController
@RequestMapping("/football/api/v1/games")
class GetGameLineUpController(
    private val getGameLineUpUseCase: GetGameLineUpUseCase,
    private val lineUpDtoMapper: LineUpDtoMapper
) {

    @GetMapping("/{gameId}/lineup")
    fun getLineUp(@PathVariable("gameId") gameId: UUID): Map<String, List<PlayerDto>> {
        val lineUp = this.getGameLineUpUseCase(gameId)
        return lineUpDtoMapper(lineUp)
    }

}