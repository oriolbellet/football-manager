package org.oriolbellet.football.commons.mapping

import javax.inject.Named

@Named
class CycleAvoidingMappingContextFactoryImpl: CycleAvoidingMappingContextFactory {
    override fun create(): CycleAvoidingMappingContext {
        return CycleAvoidingMappingContextImpl()
    }
}