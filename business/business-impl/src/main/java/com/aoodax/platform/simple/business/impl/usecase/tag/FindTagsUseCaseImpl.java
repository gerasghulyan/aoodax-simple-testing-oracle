package com.aoodax.platform.simple.business.impl.usecase.tag;

import com.aoodax.platform.simple.business.core.common.PaginationAwareDto;
import com.aoodax.platform.simple.business.core.usecase.tag.FindTagsUseCase;
import com.aoodax.platform.simple.business.core.usecase.tag.dto.response.TagGridResponse;
import com.aoodax.platform.simple.business.core.usecase.tag.dto.response.TagResponse;
import com.aoodax.platform.simple.business.impl.usecase.tag.mapper.TagPersistenceMapper;
import com.aoodax.platform.simple.persistence.tag.TagEntity;
import com.aoodax.platform.simple.persistence.tag.TagRepository;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

import static com.aoodax.jvm.common.utils.validation.ParameterValidator.assertNotNullParameterArgument;

@Service
@Slf4j
@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
@RequiredArgsConstructor
public class FindTagsUseCaseImpl implements FindTagsUseCase {

    TagRepository repository;
    TagPersistenceMapper mapper;

    @Override
    public TagGridResponse find(final PaginationAwareDto pagination) {
        assertNotNullParameterArgument(pagination, "pagination");

        log.debug("Retrieving tags for pageable: {}", pagination);
        final Page<TagEntity> tags = repository.find(PageRequest.of(pagination.getPage(), pagination.getSize()));
        log.debug("Tags successfully retrieving for pageable: {} with tags - {}", pagination, tags);
        final List<TagResponse> result = tags.stream().map(mapper::toResponse).collect(Collectors.toList());
        return TagGridResponse.builder().items(result).total(tags.getTotalElements()).build();
    }
}
