package org.oriolbellet.football.domain.season.standings

import org.oriolbellet.football.domain.match.Match
import org.oriolbellet.football.domain.match.MatchResult
import org.oriolbellet.football.domain.match.MatchResult.TIE
import org.oriolbellet.football.domain.match.MatchResult.WIN
import org.oriolbellet.football.domain.season.gameweek.GameWeek
import org.oriolbellet.football.domain.team.Team
import javax.inject.Named

@Named
class StandingsCalculatorImpl : StandingsCalculator {

    override fun invoke(teams: List<Team>, gameWeeks: List<GameWeek>): List<StandingRow> {

        val standingRows: ArrayList<StandingRow> = ArrayList()

        teams.forEach {
            standingRows.add(this.calculateStandingRow(it, gameWeeks))
        }

        return standingRows.sortedByDescending { it.standingData }

    }

    private fun calculateStandingRow(team: Team, gameWeeks: List<GameWeek>): StandingRow {

        val standingData = StandingData()

        gameWeeks.forEach { gameWeek ->
            gameWeek.matches.filter {
                it.takePart(team)
            }.map {
                standingData.sum(this.calculateStandingData(team, it))
            }
        }

        return StandingRow(team, standingData)

    }

    private fun calculateStandingData(team: Team, match: Match): StandingData {

        val teamForGoals = match.getTeamForGoals(team)
        val teamAgainstGoals = match.getTeamAgainstGoals(team)
        val points = matchResultToPoints(match.getTeamResult(team))

        return StandingData(points, teamForGoals, teamAgainstGoals)

    }

    private fun matchResultToPoints(matchResult: MatchResult): Int {

        if (matchResult == WIN) {
            return 3
        }
        if (matchResult == TIE) {
            return 1
        }
        return 0

    }


}