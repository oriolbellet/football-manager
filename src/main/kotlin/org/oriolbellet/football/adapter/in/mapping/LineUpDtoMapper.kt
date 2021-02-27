package org.oriolbellet.football.adapter.`in`.mapping

import org.oriolbellet.football.adapter.`in`.PlayerDto
import org.oriolbellet.football.domain.team.LineUp

interface LineUpDtoMapper : DtoMapper<LineUp, Map<String, List<PlayerDto>>>