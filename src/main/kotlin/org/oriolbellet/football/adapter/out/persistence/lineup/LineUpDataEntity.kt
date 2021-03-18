package org.oriolbellet.football.adapter.out.persistence.lineup

import org.oriolbellet.football.adapter.out.persistence.player.PlayerDataEntity
import org.oriolbellet.football.domain.team.BasicTactics
import java.util.*
import javax.persistence.*

@Entity(name = "LineUp")
@Table(name = "LINEUP")
data class LineUpDataEntity(

    @Id
    @Column(name = "LINEUP_ID")
    @GeneratedValue(strategy = GenerationType.AUTO)
    val lineUpId: UUID?,

    @OneToMany
    val lineUp: List<PlayerDataEntity>,

    @Column(name = "TACTIC")
    @Enumerated(EnumType.STRING)
    val tactic: BasicTactics
)
