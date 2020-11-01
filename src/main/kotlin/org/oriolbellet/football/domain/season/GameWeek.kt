package org.oriolbellet.football.domain.season

import org.oriolbellet.football.domain.match.Match
import org.oriolbellet.football.domain.match.MatchPlayer
import javax.persistence.*

@Entity
@Table(name = "GAME_WEEK")
class GameWeek {

    @Id
    @Column(name = "GAME_WEEK_ID")
    @GeneratedValue
    var matchId: Long = 0

    @OneToMany
    lateinit var matches: Set<Match>

    fun play(matchPlayer: MatchPlayer) {

        this.matches.forEach {
            it.play(matchPlayer)
        }

    }

}