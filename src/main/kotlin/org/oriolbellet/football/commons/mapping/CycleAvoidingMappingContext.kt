package org.oriolbellet.football.commons.mapping

import org.mapstruct.BeforeMapping
import org.mapstruct.MappingTarget
import org.mapstruct.TargetType

interface CycleAvoidingMappingContext {

    @BeforeMapping
    fun <T> getMappedInstance(
        source: Any,
        @TargetType targetType: Class<T>
    ): T

    @BeforeMapping
    fun storeMappedInstance(
        source: Any,
        @MappingTarget target: Any
    )

}