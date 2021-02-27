package org.oriolbellet.football.adapter.`in`.team

import org.oriolbellet.football.adapter.`in`.PlayerDto
import org.oriolbellet.football.adapter.`in`.mapping.LineUpDtoMapper
import org.oriolbellet.football.adapter.`in`.mapping.PlayerDtoMapper
import org.oriolbellet.football.application.port.`in`.GetLineUpUseCase
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import java.util.*
import kotlin.collections.LinkedHashMap

@RestController
@RequestMapping("/football/api/v1/teams")
class GetLineUpController(
    private val getLineUpUseCase: GetLineUpUseCase,
    private val lineUpDtoMapper: LineUpDtoMapper
) {

    @GetMapping("/{teamId}/lineup")
    fun getLineUp(@PathVariable("teamId") teamId: UUID): Map<String, List<PlayerDto>> {
        val lineUp = this.getLineUpUseCase(teamId)
        return lineUpDtoMapper(lineUp)
    }

}