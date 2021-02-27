package org.oriolbellet.football.adapter.`in`.game

import org.oriolbellet.football.adapter.`in`.TeamDto
import org.oriolbellet.football.adapter.`in`.mapping.TeamDtoMapper
import org.oriolbellet.football.application.port.`in`.GetGameTeamsUseCase
import org.oriolbellet.football.application.port.`in`.GetTeamsUseCase
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import java.util.*

@RestController
@RequestMapping("/football/api/v1/games")
class GetGameTeamsController(
    private val getTeamsUseCase: GetGameTeamsUseCase,
    private val teamDtoMapper: TeamDtoMapper
) {

    @GetMapping("/{gameId}/teams")
    fun findAll(@PathVariable("gameId") gameId: UUID): List<TeamDto> {
        val teams = getTeamsUseCase(gameId)
        return teams.map { this.teamDtoMapper(it) }
    }
}