package org.oriolbellet.football.domain.season

import org.hibernate.annotations.Cascade
import org.oriolbellet.football.domain.match.Match
import org.oriolbellet.football.domain.match.MatchPlayer
import javax.persistence.*

@Entity
@Table(name = "GAME_WEEK")
class GameWeek {

    @Id
    @Column(name = "GAME_WEEK_ID")
    @GeneratedValue
    var matchId: Long? = null

    @OneToMany
    lateinit var matches: Set<Match>

    fun play(matchPlayer: MatchPlayer) {

        this.matches.forEach {
            it.play(matchPlayer)
        }

    }

}