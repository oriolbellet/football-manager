package org.oriolbellet.football.adapter.`in`.game

import org.oriolbellet.football.adapter.`in`.MatchDto
import org.oriolbellet.football.adapter.`in`.mapping.MatchDtoMapper
import org.oriolbellet.football.application.port.`in`.PlayGameWeekUseCase
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import java.util.*

@RestController
@RequestMapping("/football/api/v1/games")
class PlayGameWeekController(
    private val playGameWeekUseCase: PlayGameWeekUseCase,
    private val matchDtoMapper: MatchDtoMapper
) {

    @PostMapping("/{gameId}")
    fun playGameWeek(@PathVariable("gameId") gameId: UUID): List<MatchDto> {

        return this.playGameWeekUseCase(gameId).matches.map {
            this.matchDtoMapper(it)
        }
    }
}