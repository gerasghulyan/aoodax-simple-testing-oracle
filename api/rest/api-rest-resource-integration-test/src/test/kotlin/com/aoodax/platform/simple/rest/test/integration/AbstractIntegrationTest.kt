package com.aoodax.platform.simple.rest.test.integration

import com.aoodax.platform.simple.AoodaxPlatformApplication
import org.junit.jupiter.api.extension.ExtendWith
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.boot.test.web.server.LocalServerPort
import org.springframework.test.context.TestPropertySource
import org.testcontainers.junit.jupiter.Testcontainers

@SpringBootTest(classes = [AoodaxPlatformApplication::class], webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@TestPropertySource(value = ["classpath:application.properties"])
@Testcontainers
abstract class AbstractIntegrationTest : AbstractOracleAwareIntegrationTest() {
    
    @LocalServerPort
    val port = 0
}