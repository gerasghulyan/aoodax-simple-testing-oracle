package com.aoodax.platform.simple.rest.resource.controller.tag;

import com.aoodax.jvm.common.rest.dto.request.PageableRequest;
import com.aoodax.platform.simple.business.core.common.PaginationAwareDto;
import com.aoodax.platform.simple.business.core.usecase.tag.CreateTagUseCase;
import com.aoodax.platform.simple.business.core.usecase.tag.DeleteTagUseCase;
import com.aoodax.platform.simple.business.core.usecase.tag.FindTagsUseCase;
import com.aoodax.platform.simple.business.core.usecase.tag.GetByIdTagUseCase;
import com.aoodax.platform.simple.business.core.usecase.tag.UpdateTagUseCase;
import com.aoodax.platform.simple.helper.business.CreateTagRequest;
import com.aoodax.platform.simple.helper.business.UpdateTagRequest;
import com.aoodax.platform.simple.business.core.usecase.tag.dto.response.TagGridResponse;
import com.aoodax.platform.simple.business.core.usecase.tag.dto.response.TagResponse;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@AllArgsConstructor
@RestController
@Tag(name = "Tags API")
@RequestMapping("/v1/tags")
@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
public class TagController {

    CreateTagUseCase createTagUseCase;
    GetByIdTagUseCase getByIdTagUseCase;
    FindTagsUseCase findTagsUseCase;
    UpdateTagUseCase updateTagUseCase;
    DeleteTagUseCase deleteTagUseCase;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    @Operation(description = "Create")
    public TagResponse create(@Valid @RequestBody final CreateTagRequest request) {
        log.info("Creating tag for request: {}", request);
        final TagResponse tag = createTagUseCase.create(request);
        log.info("Tag successfully created with model: {}", tag);
        return tag;
    }

    @GetMapping("/{uid}")
    @ResponseStatus(HttpStatus.OK)
    @Operation(description = "Get by uid")
    public TagResponse getByUid(@Valid @PathVariable final String uid) {
        log.info("Retrieving tag for uid: {}", uid);
        final TagResponse tag = getByIdTagUseCase.getById(uid);
        log.info("Tag successfully retrieved with model: {}", tag);
        return tag;
    }

    @PostMapping("find")
    @Operation(description = "Find by Post")
    @ResponseStatus(HttpStatus.OK)
    public TagGridResponse find(@Valid @RequestBody final PageableRequest request) {
        log.info("Retrieving all tags with pagination for request - {}", request);
        final PaginationAwareDto paginationAwareDto = PaginationAwareDto.builder()
                .page(request.getPage() - 1)
                .size(request.getSize())
                .build();
        final TagGridResponse tags = findTagsUseCase.find(paginationAwareDto);
        log.info("All tags with pagination successfully retrieved");
        return tags;
    }

    @PutMapping
    @ResponseStatus(HttpStatus.OK)
    @Operation(description = "Update")
    public TagResponse update(@Valid @RequestBody final UpdateTagRequest request) {
        log.info("Update tag for request: {}", request);
        final TagResponse tag = updateTagUseCase.update(request);
        log.info("Tag successfully updated with model: {}", tag);
        return tag;
    }

    @DeleteMapping("/{uid}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @Operation(description = "Delete")
    public TagResponse delete(@Valid @PathVariable final String uid) {
        log.info("Deleting tag for uid: {}", uid);
        final TagResponse tag = deleteTagUseCase.delete(uid);
        log.info("Tag successfully deleted with model: {}", tag);
        return tag;
    }

}
