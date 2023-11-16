package com.aoodax.platform.simple.business.impl.usecase.tag;

import com.aoodax.platform.simple.business.core.exception.NotFoundException;
import com.aoodax.platform.simple.business.core.usecase.tag.GetByIdTagUseCase;
import com.aoodax.platform.simple.business.core.usecase.tag.dto.response.TagResponse;
import com.aoodax.platform.simple.business.impl.usecase.tag.mapper.TagPersistenceMapper;
import com.aoodax.platform.simple.persistence.tag.TagRepository;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import static com.aoodax.jvm.common.utils.validation.ParameterValidator.assertHasTextParameterArgument;
import static java.lang.String.format;

@Service
@Slf4j
@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
@RequiredArgsConstructor
public class GetByIdTagUseCaseImpl implements GetByIdTagUseCase {

    TagRepository repository;
    TagPersistenceMapper mapper;

    @Override
    public TagResponse getById(final String uid) {
        assertHasTextParameterArgument(uid, "uid");

        log.debug("Retrieving tag for uid: {}", uid);
        return repository.findByUuid(uid)
                .map(mapper::toResponse)
                .orElseThrow(() -> new NotFoundException(format("The Tag not found for uid: %s", uid)));
    }
}
