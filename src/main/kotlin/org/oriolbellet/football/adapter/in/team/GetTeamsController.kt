package org.oriolbellet.football.adapter.`in`.team

import org.oriolbellet.football.adapter.`in`.TeamDto
import org.oriolbellet.football.adapter.`in`.mapping.TeamDtoMapper
import org.oriolbellet.football.application.port.`in`.GetTeamsUseCase
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/football/api/v1/teams")
class GetTeamsController(private val getTeamsUseCase: GetTeamsUseCase,
                         private val teamDtoMapper: TeamDtoMapper) {

    @GetMapping
    fun findAll(): List<TeamDto> {

        val teams = this.getTeamsUseCase()

        return teams.map { this.teamDtoMapper(it) }

    }

}