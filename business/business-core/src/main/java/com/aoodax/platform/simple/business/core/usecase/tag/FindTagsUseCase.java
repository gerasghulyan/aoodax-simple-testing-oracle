package com.aoodax.platform.simple.business.core.usecase.tag;

import com.aoodax.platform.simple.business.core.common.PaginationAwareDto;
import com.aoodax.platform.simple.business.core.usecase.tag.dto.response.TagGridResponse;

public interface FindTagsUseCase {

    TagGridResponse find(PaginationAwareDto paginationAwareDto);
}
