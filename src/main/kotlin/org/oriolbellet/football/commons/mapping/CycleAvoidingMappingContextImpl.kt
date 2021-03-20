package org.oriolbellet.football.commons.mapping

import org.mapstruct.BeforeMapping
import org.mapstruct.MappingTarget
import org.mapstruct.TargetType
import java.util.*

class CycleAvoidingMappingContextImpl: CycleAvoidingMappingContext {

    private val knownInstances: MutableMap<Any, Any> = IdentityHashMap()

    @BeforeMapping
    override fun <T> getMappedInstance(
        source: Any,
        @TargetType targetType: Class<T>
    ): T {
        return targetType.cast(knownInstances[source])
    }

    @BeforeMapping
    override fun storeMappedInstance(
        source: Any,
        @MappingTarget target: Any
    ) {
        knownInstances[source] = target
    }

}