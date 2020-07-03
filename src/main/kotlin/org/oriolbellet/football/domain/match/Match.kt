package org.oriolbellet.football.domain.match

import org.oriolbellet.football.domain.team.Team
import org.oriolbellet.football.error.ErrorCode.MATCH_ALREADY_PLAYED
import org.oriolbellet.football.error.MatchException
import javax.persistence.*

@Entity
@Table(name = "MATCH")
class Match() {

    @Id
    @Column(name = "MATCH_ID")
    @GeneratedValue
    var matchId: Long = 0

    @ManyToOne
    @JoinColumn(name = "HOME_TEAM_ID", nullable = false)
    lateinit var homeTeam: Team

    @ManyToOne
    @JoinColumn(name = "AWAY_TEAM_ID", nullable = false)
    lateinit var awayTeam: Team

    @Embedded
    var score: Score? = null

    constructor(homeTeam: Team, awayTeam: Team, score: Score) : this(homeTeam, awayTeam) {
        this.score = score
    }

    constructor(homeTeam: Team, awayTeam: Team) : this() {
        this.homeTeam = homeTeam
        this.awayTeam = awayTeam
    }

    fun play(matchPlayer: MatchPlayer) {

        if (this.isPlayed()) {
            throw MatchException(MATCH_ALREADY_PLAYED, "match with id $matchId already played")
        }

        this.score = matchPlayer.play(this.homeTeam.lineUp, this.awayTeam.lineUp)

    }

    private fun isPlayed(): Boolean {
        return this.score != null
    }

}