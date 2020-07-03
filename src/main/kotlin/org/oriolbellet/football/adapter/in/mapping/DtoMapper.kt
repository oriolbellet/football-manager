package org.oriolbellet.football.adapter.`in`.mapping

interface DtoMapper<I,O> {

    operator fun invoke(input: I): O

}