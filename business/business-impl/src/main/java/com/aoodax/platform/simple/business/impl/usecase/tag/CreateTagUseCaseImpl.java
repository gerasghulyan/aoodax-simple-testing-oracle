package com.aoodax.platform.simple.business.impl.usecase.tag;

import com.aoodax.platform.simple.business.core.exception.AlreadyExistsException;
import com.aoodax.platform.simple.business.core.usecase.tag.CreateTagUseCase;
import com.aoodax.platform.simple.helper.business.CreateTagRequest;
import com.aoodax.platform.simple.business.core.usecase.tag.dto.response.TagResponse;
import com.aoodax.platform.simple.business.impl.usecase.tag.mapper.TagPersistenceMapper;
import com.aoodax.platform.simple.persistence.tag.TagEntity;
import com.aoodax.platform.simple.persistence.tag.TagRepository;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;

import static com.aoodax.jvm.common.utils.validation.ParameterValidator.assertNotNullParameterArgument;
import static java.lang.String.format;

@Service
@Slf4j
@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
@RequiredArgsConstructor
public class CreateTagUseCaseImpl implements CreateTagUseCase {

    TagRepository repository;
    TagPersistenceMapper mapper;

    @Override
    @Transactional
    public TagResponse create(final CreateTagRequest dto) {
        assertNotNullParameterArgument(dto, "dto");
        validateDto(dto);
        log.debug("Creating tag for dto: {}", dto);
        final TagEntity tag = buildNewTag(dto);
        final TagEntity createdTag = repository.save(tag);
        return mapper.toResponse(createdTag);
    }

    private void validateDto(final CreateTagRequest dto) {
        log.debug("Validating tag for dto: {}", dto);
        repository.findByName(dto.name()).ifPresent(tagEntity -> {
            throw new AlreadyExistsException(format("The Tag already exists for name: %s", dto.name()));
        });
    }

    private TagEntity buildNewTag(final CreateTagRequest dto) {
        return TagEntity.builder().name(dto.name()).uuid(UUID.randomUUID().toString()).build();
    }
}
