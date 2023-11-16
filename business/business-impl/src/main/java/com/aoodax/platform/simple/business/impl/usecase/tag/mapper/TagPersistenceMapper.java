package com.aoodax.platform.simple.business.impl.usecase.tag.mapper;

import com.aoodax.platform.simple.business.core.usecase.tag.dto.response.TagResponse;
import com.aoodax.platform.simple.persistence.tag.TagEntity;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface TagPersistenceMapper {
    TagResponse toResponse(TagEntity entity);
}