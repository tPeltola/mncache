package fi.monad.mncache
import io.micronaut.runtime.EmbeddedApplication
import io.micronaut.test.extensions.kotest.annotation.MicronautTest
import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe

@MicronautTest
class MncacheTest(private val service: Service): StringSpec({

    "suspended service caches results by parameter" {
        service.suspended(1) shouldBe 1
        service.suspended(2) shouldBe 2
    }

    "suspended service without explicit parameters caches results by parameter" {
        service.suspendedWithoutExplicitParameters(1) shouldBe 1
        service.suspendedWithoutExplicitParameters(2) shouldBe 2
    }

    "service caches results by parameter" {
        service.sample(1) shouldBe 1
        service.sample(2) shouldBe 2
    }
})
