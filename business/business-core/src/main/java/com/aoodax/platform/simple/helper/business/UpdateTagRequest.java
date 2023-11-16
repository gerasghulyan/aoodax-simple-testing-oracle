package com.aoodax.platform.simple.helper.business;

import lombok.Builder;

import static com.aoodax.jvm.common.utils.validation.ParameterValidator.assertHasTextParameterArgument;

public record UpdateTagRequest(String uid, String name) {

    @Builder
    public UpdateTagRequest {
        assertHasTextParameterArgument(uid, "uid");
        assertHasTextParameterArgument(name, "name");
    }
}
