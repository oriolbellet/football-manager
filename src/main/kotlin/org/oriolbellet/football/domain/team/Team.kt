package org.oriolbellet.football.domain.team

import org.oriolbellet.football.domain.player.Player
import org.oriolbellet.football.error.ErrorCode
import org.oriolbellet.football.error.TeamException
import java.util.*
import javax.persistence.*

@Entity
@Table(name = "TEAM")
class Team() {

    @Id
    @Column(name = "TEAM_ID")
    @GeneratedValue(strategy = GenerationType.AUTO)
    var teamId: UUID? = null

    @Column
    var name: String = ""

    @OneToMany(mappedBy = "team", cascade = [CascadeType.ALL])
    lateinit var squad: MutableList<Player>

    @OneToOne(cascade = [CascadeType.ALL])
    lateinit var lineUp: LineUp

    @Column
    var default = false

    constructor(team: Team) : this() {
        this.name = team.name
        this.squad = team.squad.map { Player(it, this) }.toMutableList()
        this.lineUp = LineUp(team.lineUp, this.squad)
        this.default = false
    }

    fun changeTactic(tactic: BasicTactics) {
        lineUp.tactic = tactic
    }

    fun substitution(player1: Player, player2: Player) {

        if (!squad.contains(player1)) {
            throw TeamException(ErrorCode.PLAYER_NOT_BELONGING, "Player ${player1.playerId} doesn't belong to team $teamId")
        }

        if(!squad.contains(player2)) {
            throw TeamException(ErrorCode.PLAYER_NOT_BELONGING, "Player ${player2.playerId} doesn't belong to team $teamId")
        }

        lineUp.substitution(player1, player2)
    }

}
