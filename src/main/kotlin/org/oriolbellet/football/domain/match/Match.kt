package org.oriolbellet.football.domain.match

import org.oriolbellet.football.domain.Default
import org.oriolbellet.football.domain.match.MatchResult.*
import org.oriolbellet.football.domain.team.Team
import org.oriolbellet.football.error.ErrorCode.*
import org.oriolbellet.football.error.MatchException
import org.slf4j.Logger
import org.slf4j.LoggerFactory

class Match(val homeTeam: Team, val awayTeam: Team, var score: Score? = null) {

    private val logger: Logger = LoggerFactory.getLogger(Match::class.java.simpleName)
    var matchId: Long? = null

    @Default
    constructor(matchId: Long, homeTeam: Team, awayTeam: Team, score: Score?) : this(homeTeam, awayTeam, score) {
        this.matchId = matchId
    }

    fun play(matchAlgorithm: MatchAlgorithm) {
        if (this.isPlayed()) {
            throw MatchException(MATCH_ALREADY_PLAYED, "match with id $matchId already played")
        }
        logger.info("Playing ${homeTeam.name} vs ${awayTeam.name} ...")
        this.score = matchAlgorithm.play(this.homeTeam.lineUp, this.awayTeam.lineUp)
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

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as Match

        if (homeTeam != other.homeTeam) return false
        if (awayTeam != other.awayTeam) return false
        if (score != other.score) return false
        if (matchId != other.matchId) return false

        return true
    }

    override fun hashCode(): Int {
        var result = homeTeam.hashCode()
        result = 31 * result + awayTeam.hashCode()
        result = 31 * result + (score?.hashCode() ?: 0)
        result = 31 * result + (matchId?.hashCode() ?: 0)
        return result
    }


}