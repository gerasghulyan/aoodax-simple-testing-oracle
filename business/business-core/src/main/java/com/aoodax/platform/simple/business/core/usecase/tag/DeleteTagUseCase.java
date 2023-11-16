package com.aoodax.platform.simple.business.core.usecase.tag;

import com.aoodax.platform.simple.business.core.usecase.tag.dto.response.TagResponse;

public interface DeleteTagUseCase {

    TagResponse delete(String uid);

}
