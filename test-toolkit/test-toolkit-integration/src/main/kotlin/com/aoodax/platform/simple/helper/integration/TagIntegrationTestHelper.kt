package com.aoodax.platform.simple.helper.integration

import com.aoodax.platform.simple.business.core.usecase.tag.CreateTagUseCase
import com.aoodax.platform.simple.business.core.usecase.tag.dto.response.TagResponse
import com.aoodax.platform.simple.helper.business.CreateTagRequest
import com.aoodax.platform.simple.helper.business.TagRequestUnitTestHelper.Companion.buildCreateTagRequest
import org.springframework.stereotype.Component

@Component
class TagIntegrationTestHelper(
    private val createTagUseCase: CreateTagUseCase
) {

    fun persistTag(
        request: CreateTagRequest? = buildCreateTagRequest()
    ): TagResponse {
        return createTagUseCase.create(request)
    }
}