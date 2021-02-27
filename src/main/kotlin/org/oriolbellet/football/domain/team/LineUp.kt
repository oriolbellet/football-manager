package org.oriolbellet.football.domain.team

import org.oriolbellet.football.domain.player.Player
import org.oriolbellet.football.error.ErrorCode
import org.oriolbellet.football.error.ErrorCode.PLAYER_NOT_BELONGING
import org.oriolbellet.football.error.ErrorCode.PLAYER_NOT_FOUND
import org.oriolbellet.football.error.LineUpException
import java.util.*
import javax.persistence.*

@Entity
@Table(name = "LINEUP")
class LineUp() {

    @Transient
    private val numGoalkeepers = 1
    @Transient
    private val numPlayersLineUp = 11

    @Id
    @Column(name = "LINEUP_ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var lineUpId: String? = null

    @OneToMany
    var lineUp: MutableList<Player> = mutableListOf()

    @Column(name = "TACTIC")
    @Enumerated(EnumType.STRING)
    lateinit var tactic: BasicTactics

    constructor(lineUp: LineUp, players: List<Player>):this() {
        this.lineUp = players.toMutableList()
        this.tactic = lineUp.tactic
    }

    fun getGoalKeeper(): Player {
        return lineUp[0];
    }

    fun getDefenders(): List<Player> {
        val fromIndex = numGoalkeepers
        return lineUp.subList(fromIndex, fromIndex + tactic.getNumDefenders())
    }

    fun getMidfielders(): List<Player> {
        val fromIndex = numGoalkeepers + tactic.getNumDefenders()
        return lineUp.subList(fromIndex, fromIndex + tactic.getNumMidfielders())
    }

    fun getForwards(): List<Player> {
        val fromIndex = numGoalkeepers + tactic.getNumDefenders() + tactic.getNumMidfielders()
        return lineUp.subList(fromIndex, numPlayersLineUp)
    }

    fun getMidfieldPoints(): Int {
        return this.getMidfielders().stream().mapToInt{ x -> x.average }.sum()
    }

    fun getAttackPoints(): Int {
        return this.getForwards().stream().mapToInt{ x -> x.average }.sum()
    }

    fun getDefensePoints(): Int {
        return this.getDefenders().stream().mapToInt{ x -> x.average }.sum() +
                this.getGoalKeeper().average
    }

    fun substitution(player1: Player, player2: Player) {

        val player1pos = lineUp.indexOf(player1)
        val player2pos = lineUp.indexOf(player2)

        if (player1pos == -1) {
            throw LineUpException(PLAYER_NOT_BELONGING, "Player ${player1.playerId} not belongs to lineUp $lineUpId")
        }

        if (player2pos == -1) {
            throw LineUpException(PLAYER_NOT_BELONGING, "Player ${player2.playerId} not belongs to lineUp $lineUpId")
        }

        Collections.swap(lineUp, player1pos, player2pos)
    }


}