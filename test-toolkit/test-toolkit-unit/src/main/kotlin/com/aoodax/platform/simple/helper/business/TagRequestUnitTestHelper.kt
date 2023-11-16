package com.aoodax.platform.simple.helper.business

import com.aoodax.jvm.common.test.toolkit.Randomizer.Companion.generateRandomString
import com.aoodax.platform.simple.business.core.usecase.tag.dto.response.TagResponse

class TagRequestUnitTestHelper {

    companion object {

        fun buildCreateTagRequest(
            name: String? = generateRandomString(),
        ): CreateTagRequest = CreateTagRequest(
            name
        )

        fun buildTagResponse(
            uid: String? = generateRandomString(),
            name: String? = generateRandomString(),
        ): TagResponse = TagResponse(
            uid,
            name
        )
    }
}