package org.oriolbellet.football.domain.game

import org.oriolbellet.football.domain.match.MatchAlgorithm
import org.oriolbellet.football.domain.season.GameWeek
import org.oriolbellet.football.domain.season.Season
import org.oriolbellet.football.domain.team.Team
import java.util.*
import javax.persistence.*

@Entity
@Table(name = "GAME")
class Game() {

    @Id
    @Column(name = "GAME_ID")
    @GeneratedValue(strategy = GenerationType.AUTO)
    val gameId: UUID? = null

    @OneToMany(cascade = [CascadeType.ALL])
    var teams: MutableList<Team> = mutableListOf()

    @OneToOne(cascade = [CascadeType.ALL])
    var userTeam: Team? = null

    @OneToOne(cascade = [CascadeType.ALL])
    var season: Season? = null

    constructor(teams: List<Team>, season: Season, userTeam: Team): this() {
        this.teams = teams.toMutableList()
        this.season = season
        this.userTeam = userTeam
    }

    fun play(matchAlgorithm: MatchAlgorithm) {
        season!!.playCurrentWeek(matchAlgorithm)
    }

    fun getLastGameWeek(): GameWeek {
        return season!!.getLastGameWeek()
    }

    fun getGameWeeksFromFirstToLastPlayed(): List<GameWeek> {
        return season!!.gameWeeks.subList(0, season!!.currentWeek)
    }

}