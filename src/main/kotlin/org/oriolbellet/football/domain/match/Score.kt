package org.oriolbellet.football.domain.match

import javax.persistence.Column
import javax.persistence.Embeddable

@Embeddable
class Score() {

    @Column
    var homeTeamGoals: Int = 0

    @Column
    var awayTeamGoals: Int = 0

    constructor(homeTeamGoals: Int,  awayTeamGoals: Int): this() {
        this.homeTeamGoals = homeTeamGoals
        this.awayTeamGoals = awayTeamGoals
    }

}
