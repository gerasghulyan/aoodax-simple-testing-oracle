package com.aoodax.platform.simple.business.impl.usecase.tag;

import com.aoodax.platform.simple.business.core.exception.NotFoundException;
import com.aoodax.platform.simple.business.core.usecase.tag.DeleteTagUseCase;
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
public class DeleteTagUseCaseImpl implements DeleteTagUseCase {

    TagRepository repository;
    TagPersistenceMapper mapper;

    @Override
    public TagResponse delete(final String uid) {
        assertHasTextParameterArgument(uid, "uid");

        log.debug("Deleting tag for uid: {}", uid);
        return repository.findByUuid(uid)
                .map(tag -> {
                    tag.setDeleted(true);
                    repository.save(tag);
                    return tag;
                })
                .map(mapper::toResponse)
                .orElseThrow(() -> new NotFoundException(format("The Tag not found for uid: %s", uid)));
    }
}
