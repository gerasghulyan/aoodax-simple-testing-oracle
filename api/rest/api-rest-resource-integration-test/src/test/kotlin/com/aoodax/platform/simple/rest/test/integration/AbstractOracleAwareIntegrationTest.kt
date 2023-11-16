package com.aoodax.platform.simple.rest.test.integration

import org.junit.jupiter.api.BeforeAll
import org.springframework.test.context.DynamicPropertyRegistry
import org.springframework.test.context.DynamicPropertySource
import org.testcontainers.junit.jupiter.Container

abstract class AbstractOracleAwareIntegrationTest {
    companion object {
        @Container
        private val oracleContainer = OracleTestContainer.prepareContainer()

        @JvmStatic
        @BeforeAll
        fun setUp() {
            oracleContainer.start()
            println(oracleContainer.logs);
        }


        @JvmStatic
        @DynamicPropertySource
        fun setDatasourceProperties(registry: DynamicPropertyRegistry) {
            registerOracleProperties(registry)
        }

        private fun registerOracleProperties(registry: DynamicPropertyRegistry) {
            println("test-test-test")
            println(oracleContainer.jdbcUrl)
            println(oracleContainer.oraclePort)
            println("test-test-test")
            registry.add("spring.datasource.url") { oracleContainer.jdbcUrl }
            registry.add("spring.datasource.username") { oracleContainer.username }
            registry.add("spring.datasource.password") { oracleContainer.password }
        }

    }
}