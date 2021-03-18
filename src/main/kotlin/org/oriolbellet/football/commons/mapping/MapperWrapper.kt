package org.oriolbellet.football.commons.mapping

interface MapperWrapper<Domain, Data> {
    fun toDomain(data: Data): Domain
    fun toData(domain: Domain): Data
}