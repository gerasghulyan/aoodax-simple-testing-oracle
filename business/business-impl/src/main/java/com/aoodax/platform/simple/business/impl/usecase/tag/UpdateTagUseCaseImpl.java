package com.aoodax.platform.simple.business.impl.usecase.tag;

import com.aoodax.platform.simple.business.core.exception.AlreadyExistsException;
import com.aoodax.platform.simple.business.core.exception.NotFoundException;
import com.aoodax.platform.simple.business.core.usecase.tag.UpdateTagUseCase;
import com.aoodax.platform.simple.helper.business.UpdateTagRequest;
import com.aoodax.platform.simple.business.core.usecase.tag.dto.response.TagResponse;
import com.aoodax.platform.simple.business.impl.usecase.tag.mapper.TagPersistenceMapper;
import com.aoodax.platform.simple.persistence.tag.TagEntity;
import com.aoodax.platform.simple.persistence.tag.TagRepository;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import static com.aoodax.jvm.common.utils.validation.ParameterValidator.assertNotNullParameterArgument;
import static java.lang.String.format;

@Service
@Slf4j
@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
@RequiredArgsConstructor
public class UpdateTagUseCaseImpl implements UpdateTagUseCase {

    TagRepository repository;
    TagPersistenceMapper mapper;

    @Override
    public final TagResponse update(final UpdateTagRequest dto) {
        assertNotNullParameterArgument(dto, "dto");

        final TagEntity tag = findTagByUidOrThrow(dto.uid());
        assertTagDoesNotConflictWithName(dto.name(), tag);

        final TagEntity updatedTag = updateAndSaveTag(dto, tag);
        return mapper.toResponse(updatedTag);
    }

    private TagEntity findTagByUidOrThrow(final String uid) {
        return repository.findByUuid(uid)
                .orElseThrow(() -> new NotFoundException(format("The Tag not found for uid: %s", uid)));
    }

    private void assertTagDoesNotConflictWithName(final String tagName,
                                                  final TagEntity tagEntity) {
        repository.findByName(tagName)
                .filter(tag -> !tag.getUuid().equals(tagEntity.getUuid()))
                .ifPresent(tag -> {
                    throw new AlreadyExistsException(format("The Tag already exists for name: %s", tagName));
                });
    }

    private TagEntity updateAndSaveTag(final UpdateTagRequest dto,
                                       final TagEntity tagEntity) {
        log.debug("Update tag for dto: {}", dto);
        tagEntity.setName(dto.name());
        return repository.save(tagEntity);
    }

}
