package org.oriolbellet.football.domain.season

import org.oriolbellet.football.domain.match.Match
import org.oriolbellet.football.domain.match.MatchAlgorithm
import javax.persistence.*

@Entity
@Table(name = "GAME_WEEK")
class GameWeek() {

    @Id
    @Column(name = "GAME_WEEK_ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var gameWeekId: Long? = null

    @OneToMany(cascade = [CascadeType.ALL])
    var matches: MutableList<Match> = mutableListOf()

    constructor(matches: List<Match>): this() {
        this.matches = matches.toMutableList()
    }

    fun play(matchAlgorithm: MatchAlgorithm) {
        this.matches.forEach {
            it.play(matchAlgorithm)
        }
    }

}