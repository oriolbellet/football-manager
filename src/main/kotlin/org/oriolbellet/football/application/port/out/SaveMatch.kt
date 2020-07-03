package org.oriolbellet.football.application.port.out

import org.oriolbellet.football.domain.match.Match

interface SaveMatch {

    fun save(match: Match): Match

}