package org.oriolbellet.football.domain.season

import org.oriolbellet.football.domain.match.MatchAlgorithm
import org.oriolbellet.football.domain.team.Team
import java.util.*
import javax.persistence.*

@Entity
@Table(name = "SEASON")
class Season() {

    @Id
    @Column(name = "SEASON_ID")
    @GeneratedValue(strategy = GenerationType.AUTO)
    var seasonId: UUID? = null

    @Column(name = "CURRENT_WEEK")
    var currentWeek: Int = 0

    @OneToMany(cascade = [CascadeType.ALL])
    var gameWeeks: MutableList<GameWeek> = mutableListOf()

    @OneToMany(cascade = [CascadeType.ALL])
    var teams: MutableList<Team> = mutableListOf()

    constructor(teams: List<Team>, gameWeeksGeneratorProvider: GameWeeksGeneratorProvider): this() {
        this.teams = teams.toMutableList()
        this.gameWeeks = gameWeeksGeneratorProvider(this.teams.size)(this.teams).toMutableList()
    }

    fun playCurrentWeek(matchAlgorithm: MatchAlgorithm) {
        this.gameWeeks[this.currentWeek++].play(matchAlgorithm)
    }

    fun getLastGameWeek(): GameWeek {
        return gameWeeks[currentWeek-1]
    }
    fun getGameWeeksFromFirstToLastPlayed(): List<GameWeek> {
        return gameWeeks.subList(0, currentWeek)
    }

}