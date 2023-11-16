package com.aoodax.platform.simple.persistence.tag;

import com.aoodax.platform.simple.persistence.common.AbstractUuidAwareEntity;
import jakarta.persistence.Entity;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
@Entity(name = "TAG")
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
