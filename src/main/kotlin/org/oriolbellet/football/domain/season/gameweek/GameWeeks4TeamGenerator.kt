package org.oriolbellet.football.domain.season.gameweek

import org.oriolbellet.football.commons.NAMED_GAME_WEEK_4_TEAMS_GENERATOR
import org.oriolbellet.football.domain.match.Match
import org.oriolbellet.football.domain.team.Team
import javax.inject.Named

@Named(NAMED_GAME_WEEK_4_TEAMS_GENERATOR)
class GameWeeks4TeamGenerator: GameWeeksGenerator {

    override fun invoke(teams: List<Team>): List<GameWeek> {

        val teamSize = teams.size

        if (teamSize != 4) {
            throw IllegalArgumentException("Invalid size: [$teamSize]. Must be 4")
        }

        val gameWeeks = ArrayList<GameWeek>()

        val match0101 = Match(teams[0],teams[1])
        val match0102 = Match(teams[2],teams[3])

        gameWeeks.add(GameWeek(listOf(match0101, match0102)))

        val match0201 = Match(teams[3],teams[0])
        val match0202 = Match(teams[1],teams[2])

        gameWeeks.add(GameWeek(listOf(match0201, match0202)))

        val match0301 = Match(teams[0],teams[2])
        val match0302 = Match(teams[1],teams[3])

        gameWeeks.add(GameWeek(listOf(match0301, match0302)))

        val match0401 = Match(teams[1],teams[0])
        val match0402 = Match(teams[3],teams[2])

        gameWeeks.add(GameWeek(listOf(match0401, match0402)))

        val match0501 = Match(teams[0],teams[3])
        val match0502 = Match(teams[2],teams[1])

        gameWeeks.add(GameWeek(listOf(match0501, match0502)))

        val match0601 = Match(teams[2],teams[0])
        val match0602 = Match(teams[3],teams[1])

        gameWeeks.add(GameWeek(listOf(match0601, match0602)))

        return gameWeeks
        
    }
}