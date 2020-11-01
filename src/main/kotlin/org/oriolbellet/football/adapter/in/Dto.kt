package org.oriolbellet.football.adapter.`in`

data class MatchDto(val matchId: Long, val homeTeam: TeamDto, val awayTeam: TeamDto, val score: ScoreDto?)
data class ScoreDto(val homeTeam: Int, val awayTeam: Int)
data class TeamDto(val teamId: String, val name: String)
data class PlayerDto(val playerId: String, val name: String, val average: Int)
data class SeasonDto(val seasonId: Long, val currentWeek: Int)
data class StandingRowDto(val team: String, val points: Int, val gf: Int, val ga: Int)