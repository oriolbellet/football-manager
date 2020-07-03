package org.oriolbellet.football.adapter.`in`.team

import org.oriolbellet.football.adapter.`in`.PlayerDto
import org.oriolbellet.football.adapter.`in`.TeamDto
import org.oriolbellet.football.adapter.`in`.mapping.TeamDtoMapper
import org.oriolbellet.football.application.port.`in`.GetTeamUseCase
import org.oriolbellet.football.domain.team.Team
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/football/api/v1/teams")
class GetTeamController(private val getTeamUseCase: GetTeamUseCase,
                        private val teamDtoMapper: TeamDtoMapper) {

    @GetMapping("/{teamId}")
    fun findById(@PathVariable("teamId") teamId: String): TeamDto {

        val team = this.getTeamUseCase(teamId)

        return this.teamDtoMapper(team)

    }

}