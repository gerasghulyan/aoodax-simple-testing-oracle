package com.aoodax.platform.simple.persistence.common;

import jakarta.persistence.Column;
import jakarta.persistence.MappedSuperclass;

import java.time.LocalDateTime;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.SuperBuilder;

@MappedSuperclass
@Data
@EqualsAndHashCode(callSuper = true)
@SuperBuilder
public abstract class AbstractUuidAwareEntity extends AbstractEntity {

    @Column(name = "UUID", updatable = false, nullable = false, unique = true)
    private String uuid;

    protected AbstractUuidAwareEntity() {
        super();
    }

    protected AbstractUuidAwareEntity(final String uuid) {
        this.uuid = uuid;
    }

    protected AbstractUuidAwareEntity(
            final Long id,
            final LocalDateTime createdAt,
            final LocalDateTime updatedAt,
            final boolean isDeleted,
            final String uuid) {
        super(id, createdAt, updatedAt, isDeleted);
        this.uuid = uuid;
    }
}
