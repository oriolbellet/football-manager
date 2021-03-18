package org.oriolbellet.football.domain.match

import javax.persistence.Column
import javax.persistence.Embeddable

@Embeddable
class Score() {

    @Column
    var homeTeamGoals: Int = 0

    @Column
    var awayTeamGoals: Int = 0

    constructor(homeTeamGoals: Int, awayTeamGoals: Int) : this() {
        this.homeTeamGoals = homeTeamGoals
        this.awayTeamGoals = awayTeamGoals
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as Score

        if (homeTeamGoals != other.homeTeamGoals) return false
        if (awayTeamGoals != other.awayTeamGoals) return false

        return true
    }

    override fun hashCode(): Int {
        var result = homeTeamGoals
        result = 31 * result + awayTeamGoals
        return result
    }


}
