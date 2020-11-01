package org.oriolbellet.football.domain.season

import org.oriolbellet.football.domain.match.Match
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

    fun play() {

    }

}