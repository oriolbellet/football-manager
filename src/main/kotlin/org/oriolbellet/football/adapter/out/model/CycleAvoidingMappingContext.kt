package org.oriolbellet.football.adapter.out.model

import org.mapstruct.BeforeMapping
import org.mapstruct.MappingTarget
import org.mapstruct.TargetType
import java.util.*

class CycleAvoidingMappingContext {

    private val knownInstances: MutableMap<Any, Any> = IdentityHashMap()

    @BeforeMapping
    fun <T> getMappedInstance(
        source: Any,
        @TargetType targetType: Class<T>
    ): T {
        return targetType.cast(knownInstances[source])
    }

    @BeforeMapping
    fun storeMappedInstance(
        source: Any,
        @MappingTarget target: Any
    ) {
        knownInstances[source] = target
    }

}