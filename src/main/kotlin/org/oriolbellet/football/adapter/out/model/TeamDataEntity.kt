package org.oriolbellet.football.adapter.out.model

import java.util.*
import javax.persistence.*

@Entity
@Table(name = "TEAM")
data class TeamDataEntity(

    @Id
    @Column(name = "TEAM_ID")
    @GeneratedValue(strategy = GenerationType.AUTO)
    val teamId: UUID?,

    @Column
    val name: String,

    @OneToMany(cascade = [CascadeType.ALL])
    @JoinColumn(name = "TEAM_ID")
    val squad: List<PlayerDataEntity>,

    @OneToOne(cascade = [CascadeType.ALL])
    val lineUp: LineUpDataEntity,

    @Column
    val def: Boolean = false)
