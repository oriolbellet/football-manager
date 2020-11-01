package org.oriolbellet.football.domain.season

import org.oriolbellet.football.domain.match.MatchPlayer
import javax.persistence.*

@Entity
@Table(name = "SEASON")
class Season {

    @Id
    @Column(name = "SEASON_ID")
    @GeneratedValue
    var seasonId: Long = 0

    @Column(name = "CURRENT_WEEK")
    var currentWeek: Int = 0

    @OneToMany
    lateinit var gameWeeks: List<GameWeek>

    fun playCurrentWeek(matchPlayer: MatchPlayer) {

        this.gameWeeks[this.currentWeek++].play(matchPlayer)

    }


}