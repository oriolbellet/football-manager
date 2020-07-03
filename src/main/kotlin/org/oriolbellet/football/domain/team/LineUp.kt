package org.oriolbellet.football.domain.team

import org.oriolbellet.football.domain.player.Player
import javax.persistence.*

@Entity
@Table(name = "LINEUP")
class LineUp {

    @Transient
    private val numGoalkeepers = 1
    @Transient
    private val numPlayersLineUp = 11

    @Id
    @Column(name = "LINEUP_ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    lateinit var lineUpId: String

    @OneToMany
    lateinit var lineUp: List<Player>

    @Column(name = "TACTIC")
    @Enumerated(EnumType.STRING)
    lateinit var tactic: BasicTactics

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


}