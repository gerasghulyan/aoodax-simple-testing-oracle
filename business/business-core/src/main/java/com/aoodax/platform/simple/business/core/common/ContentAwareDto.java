package com.aoodax.platform.simple.business.core.common;

import lombok.AccessLevel;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import lombok.experimental.FieldDefaults;

import static com.aoodax.jvm.common.utils.validation.ParameterValidator.assertHasTextParameterArgument;

@Data
@EqualsAndHashCode
@ToString
@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
public abstract class ContentAwareDto {

    String alias;
    String name;
    StatusDto status;
    String description;

    public ContentAwareDto(
            final String alias,
            final String name,
            final StatusDto status,
            final String description) {
        assertHasTextParameterArgument(alias, "alias");
        assertHasTextParameterArgument(name, "name");
        assertHasTextParameterArgument(description, "description");
        this.alias = alias;
        this.name = name;
        this.status = status;
        this.description = description;
    }
}
