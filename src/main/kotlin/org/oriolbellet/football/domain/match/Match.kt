package org.oriolbellet.football.domain.match

import org.oriolbellet.football.domain.match.MatchResult.*
import org.oriolbellet.football.domain.team.Team
import org.oriolbellet.football.error.ErrorCode.*
import org.oriolbellet.football.error.MatchException
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import javax.persistence.*
import javax.persistence.GenerationType.IDENTITY

@Entity
@Table(name = "MATCH")
class Match() {

    @Transient
    private val logger: Logger = LoggerFactory.getLogger(Match::class.java.simpleName)

    @Id
    @Column(name = "MATCH_ID")
    @GeneratedValue(strategy = IDENTITY)
    val matchId: Long? = null

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

        logger.info("Playing ${homeTeam.name} vs ${awayTeam.name} ...")

        this.score = matchPlayer.play(this.homeTeam.lineUp, this.awayTeam.lineUp)

    }

    private fun isPlayed(): Boolean {
        return this.score != null
    }

    fun takePart(team: Team): Boolean {
        return this.homeTeam == team || this.awayTeam == team
    }

    fun getTeamResult(team: Team): MatchResult {

        if (!this.takePart(team)) {
            throw MatchException(TEAM_NOT_BELONG_TO_MATCH, "team $team.teamId does not take part in the match $matchId ")
        }

        if (!this.isPlayed()) {
            throw MatchException(MATCH_NOT_PLAYED, "match with id $matchId not played yet")
        }

        if (this.score!!.homeTeamGoals == this.score!!.awayTeamGoals) {
            return TIE
        }

        if (team == this.homeTeam) {
            return if (this.score!!.homeTeamGoals > this.score!!.awayTeamGoals) WIN else LOSE
        }

        return if (this.score!!.awayTeamGoals > this.score!!.homeTeamGoals) WIN else LOSE

    }

    fun getTeamForGoals(team: Team): Int {

        if (!this.takePart(team)) {
            throw MatchException(TEAM_NOT_BELONG_TO_MATCH, "team $team.teamId does not take part in the match $matchId ")
        }

        if (team == this.homeTeam) {
            return this.score?.homeTeamGoals ?: 0
        }

        return this.score?.awayTeamGoals ?: 0

    }

    fun getTeamAgainstGoals(team: Team): Int {

        if (!this.takePart(team)) {
            throw MatchException(TEAM_NOT_BELONG_TO_MATCH, "team $team.teamId does not take part in the match $matchId ")
        }

        if (team == this.homeTeam) {
            return this.score?.awayTeamGoals ?: 0
        }

        return this.score?.homeTeamGoals ?: 0

    }

    fun played(score: Score) {

        if (this.isPlayed()) {
            throw MatchException(MATCH_ALREADY_PLAYED, "match with id $matchId already played")
        }

        this.score = score

    }

}