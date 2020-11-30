package org.oriolbellet.football.adapter.`in`

import com.fasterxml.jackson.annotation.JsonInclude
import com.fasterxml.jackson.annotation.JsonInclude.Include.NON_NULL

data class MatchDto(val matchId: Long, val homeTeam: String, val awayTeam: String, @JsonInclude(NON_NULL) val score: ScoreDto?)
data class ScoreDto(val homeTeamGoals: Int, val awayTeamGoals: Int)
data class TeamDto(val teamId: String, val name: String)
data class PlayerDto(val playerId: String, val name: String, val average: Int)
data class SeasonDto(val seasonId: Long, val currentWeek: Int)
data class StandingRowDto(val team: String, val points: Int, val gf: Int, val ga: Int)