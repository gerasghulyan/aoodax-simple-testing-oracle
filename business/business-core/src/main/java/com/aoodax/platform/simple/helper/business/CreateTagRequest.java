package com.aoodax.platform.simple.helper.business;

import com.aoodax.jvm.common.utils.validation.ParameterValidator;
import com.aoodax.platform.simple.business.core.common.BusinessRequest;
import lombok.Builder;

public record CreateTagRequest(String name) implements BusinessRequest {

    @Builder
    public CreateTagRequest {
        ParameterValidator.assertHasTextParameterArgument(name, "name");
    }
}
