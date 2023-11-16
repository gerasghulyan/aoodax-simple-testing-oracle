package com.aoodax.platform.simple.rest.test.integration.tag

import com.aoodax.jvm.common.rest.dto.request.PageableRequest
import com.aoodax.platform.simple.business.core.usecase.tag.dto.response.TagGridResponse
import com.aoodax.platform.simple.business.core.usecase.tag.dto.response.TagResponse
import com.aoodax.platform.simple.helper.business.TagRequestUnitTestHelper.Companion.buildCreateTagRequest
import com.aoodax.platform.simple.helper.integration.TagIntegrationTestHelper
import com.aoodax.platform.simple.rest.test.integration.AbstractIntegrationTest
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpEntity
import org.springframework.http.HttpMethod
import org.springframework.web.client.RestTemplate

class TagControllerIntegrationTest : AbstractIntegrationTest() {

    @Autowired
    private lateinit var tagIntegrationTestHelper: TagIntegrationTestHelper

    @Autowired
    private lateinit var restTemplate: RestTemplate

    @Test
    fun `create tag`() {
        tagIntegrationTestHelper.persistTag(buildCreateTagRequest(name = "create tags"))
        val request = buildCreateTagRequest()
        tagIntegrationTestHelper.persistTag(request)
        tagIntegrationTestHelper.persistTag(buildCreateTagRequest())
        tagIntegrationTestHelper.persistTag(buildCreateTagRequest())
        tagIntegrationTestHelper.persistTag(buildCreateTagRequest())
        tagIntegrationTestHelper.persistTag(buildCreateTagRequest())

        val testCreate = restTemplate.exchange(
            "http://localhost:${port}/v1/tags",
            HttpMethod.POST,
            HttpEntity(buildCreateTagRequest()),
            TagResponse::class.java
        )
        val page = PageableRequest.builder().page(1).size(50).build()
        val testFind = restTemplate.exchange(
            "http://localhost:${port}/v1/tags/find",
            HttpMethod.POST,
            HttpEntity(page),
            TagGridResponse::class.java
        )

        println("Asd")
//
//        println(exchange)
//        controller.create(request).let {
//            assertThat(it.uid).isNotEmpty
//            assertThat(it.name).isEqualTo(request.name)
//        }
    }

    @Test
    fun `find tags`() {
        tagIntegrationTestHelper.persistTag(buildCreateTagRequest(name = "find tags"))
        val page = PageableRequest.builder().page(1).size(50).build()
        val exchange2 = restTemplate.exchange(
            "http://localhost:${port}/v1/tags/find",
            HttpMethod.POST,
            HttpEntity(page),
            TagGridResponse::class.java
        )

        println("Asd")
//
//        println(exchange)
//        controller.create(request).let {
//            assertThat(it.uid).isNotEmpty
//            assertThat(it.name).isEqualTo(request.name)
//        }
    }
}
