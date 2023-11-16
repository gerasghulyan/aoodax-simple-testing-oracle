package com.aoodax.platform.simple.business.core.usecase.tag.dto.response;

import com.aoodax.platform.simple.business.core.common.BusinessResult;

public record TagResponse(String uuid, String name) implements BusinessResult {
}
