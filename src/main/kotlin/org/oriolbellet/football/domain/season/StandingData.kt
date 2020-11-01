package org.oriolbellet.football.domain.season

class StandingData(var points: Int, var goalsFor: Int, var goalsAgainst: Int): Comparable<StandingData> {

    constructor() : this(0, 0, 0)

    override fun compareTo(other: StandingData): Int {
        if (this.points != other.points)
            return this.points - other.points
        if (this.goalsDiff() != other.goalsDiff())
            return this.goalsDiff() - other.goalsDiff()
        return this.goalsFor - other.goalsFor
    }

    private fun goalsDiff(): Int {
        return this.goalsFor - this.goalsAgainst
    }

    fun sum(other: StandingData) {
        this.points += other.points
        this.goalsFor += other.goalsFor
        this.goalsAgainst += other.goalsAgainst
    }

}
