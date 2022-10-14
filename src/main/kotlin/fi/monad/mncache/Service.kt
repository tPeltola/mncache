package fi.monad.mncache

import io.micronaut.cache.annotation.Cacheable
import jakarta.inject.Singleton

@Singleton
open class Service {
    @Cacheable(cacheNames = ["suspended"], parameters = ["first"])
    open suspend fun suspended(first: Int): Int {
            return first
    }

    @Cacheable(cacheNames = ["suspended2"])
    open suspend fun suspendedWithoutExplicitParameters(first: Int): Int {
            return first
    }

    @Cacheable(cacheNames = ["sample"], parameters = ["first"])
    open fun sample(first: Int): Int {
            return first
    }
}