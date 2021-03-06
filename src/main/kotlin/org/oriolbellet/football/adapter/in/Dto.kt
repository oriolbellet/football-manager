package org.oriolbellet.football.adapter.`in`

import com.fasterxml.jackson.annotation.JsonInclude
import com.fasterxml.jackson.annotation.JsonInclude.Include.NON_NULL
import java.util.*

data class MatchDto(val matchId: Long, val homeTeam: String, val awayTeam: String, @JsonInclude(NON_NULL) val score: ScoreDto?)
data class ScoreDto(val homeTeamGoals: Int, val awayTeamGoals: Int)
data class TeamDto(val teamId: UUID, val name: String)
data class PlayerDto(val playerId: UUID, val name: String, val average: Int)
data class StandingRowDto(val team: String, val points: Int, val gf: Int, val ga: Int)
data class GameDto(val gameId: UUID, val teams: List<TeamDto>)