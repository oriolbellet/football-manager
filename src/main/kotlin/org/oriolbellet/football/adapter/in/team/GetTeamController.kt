package org.oriolbellet.football.adapter.`in`.team

import org.oriolbellet.football.adapter.`in`.TeamDto
import org.oriolbellet.football.adapter.`in`.mapping.TeamDtoMapper
import org.oriolbellet.football.application.port.`in`.GetTeamUseCase
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import java.util.*

@RestController
@RequestMapping("/football/api/v1/teams")
class GetTeamController(private val getTeamUseCase: GetTeamUseCase,
                        private val teamDtoMapper: TeamDtoMapper) {

    @GetMapping("/{teamId}")
    fun findById(@PathVariable("teamId") teamId: UUID): TeamDto {

        val team = this.getTeamUseCase(teamId)

        return this.teamDtoMapper(team)

    }

}