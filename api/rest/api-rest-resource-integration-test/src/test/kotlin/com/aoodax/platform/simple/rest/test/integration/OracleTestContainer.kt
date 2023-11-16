package com.aoodax.platform.simple.rest.test.integration

import org.testcontainers.containers.OracleContainer
import org.testcontainers.junit.jupiter.Testcontainers

@Testcontainers
class OracleTestContainer {
    companion object {
        private const val DOCKER_TAG = "gvenzl/oracle-xe:18-faststart"
//        private const val DOCKER_TAG = "gvenzl/oracle-xe:21-slim-faststart"
        private const val DB_INIT_SCRIPT = "database/init.sql"

        fun prepareContainer(): OracleContainer {
            val oracleContainer = OracleContainer(DOCKER_TAG)
            oracleContainer.withInitScript(DB_INIT_SCRIPT)
            oracleContainer.withDatabaseName("test")
            oracleContainer.withUsername("test")
            oracleContainer.withPassword("test")
            oracleContainer.withExposedPorts(1521)
            oracleContainer.withReuse(true)
            return oracleContainer
        }
    }
}
