package org.oriolbellet.football.domain.team

import org.oriolbellet.football.domain.player.Player
import javax.persistence.*

@Entity
@Table(name = "LINEUP")
class LineUp {

    @Id
    @Column(name = "LINEUP_ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    lateinit var lineUpId: String

    @OneToMany
    lateinit var lineUp: List<Player>

}