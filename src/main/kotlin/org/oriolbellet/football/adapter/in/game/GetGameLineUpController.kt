package org.oriolbellet.football.adapter.`in`.game

import org.oriolbellet.football.adapter.`in`.PlayerDto
import org.oriolbellet.football.adapter.`in`.mapping.PlayerDtoMapper
import org.oriolbellet.football.application.port.`in`.GetGameLineUpUseCase
import org.oriolbellet.football.application.port.`in`.GetLineUpUseCase
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import java.util.*
import kotlin.collections.LinkedHashMap

@RestController
@RequestMapping("/football/api/v1/games")
class GetGameLineUpController(private val getGameLineUpUseCase: GetGameLineUpUseCase,
                              private val playerDtoMapper: PlayerDtoMapper) {

    @GetMapping("/{gameId}/lineup")
    fun getLineUp(@PathVariable("gameId") gameId: UUID): Map<String, List<PlayerDto>> {

        val lineUp = this.getGameLineUpUseCase(gameId)

        val result = LinkedHashMap<String, List<PlayerDto>>()

        result["goalkeeper"] = Collections.singletonList(this.playerDtoMapper(lineUp.getGoalKeeper()))
        result["defender"] = lineUp.getDefenders().map {  this.playerDtoMapper(it) }
        result["midfielder"] = lineUp.getMidfielders().map {  this.playerDtoMapper(it) }
        result["forward"] = lineUp.getForwards().map {  this.playerDtoMapper(it) }
        return result

    }

}