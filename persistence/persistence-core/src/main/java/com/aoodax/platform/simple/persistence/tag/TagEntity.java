package com.aoodax.platform.simple.persistence.tag;

import com.aoodax.platform.simple.persistence.common.AbstractUuidAwareEntity;
import jakarta.persistence.Entity;
import jakarta.persistence.NamedStoredProcedureQuery;
import jakarta.persistence.ParameterMode;
import jakarta.persistence.StoredProcedureParameter;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
@Entity(name = "TAG")
@NamedStoredProcedureQuery(
        name = "getTagByIdProc",
        procedureName = "TEST_GET_TAG_BY_ID_FUNC",
        resultClasses = { TagEntity.class },
        parameters = {
                @StoredProcedureParameter(name = "IN_ID", mode = ParameterMode.IN, type = Long.class),
                @StoredProcedureParameter(name = "TagEntity", mode = ParameterMode.OUT, type = TagEntity.class)
        }
)
public class TagEntity extends AbstractUuidAwareEntity {

    private String name;

    @Builder
    public TagEntity(final Long id,
                     final LocalDateTime createdAt,
                     final LocalDateTime updatedAt,
                     final boolean isDeleted,
                     final String uuid,
                     final String name) {
        super(id, createdAt, updatedAt, isDeleted, uuid);
        this.name = name;
    }
}
