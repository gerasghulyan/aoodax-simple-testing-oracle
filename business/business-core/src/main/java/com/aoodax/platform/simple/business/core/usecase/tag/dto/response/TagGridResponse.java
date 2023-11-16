package com.aoodax.platform.simple.business.core.usecase.tag.dto.response;

import com.aoodax.platform.simple.business.core.common.AbstractGridAwareResponseDto;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;
import lombok.experimental.FieldDefaults;

import java.util.List;

@Getter
@EqualsAndHashCode(callSuper = true)
@ToString
@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
@NoArgsConstructor
public class TagGridResponse extends AbstractGridAwareResponseDto<TagResponse> {

    @Builder
    public TagGridResponse(final List<TagResponse> items,
                           final long total) {
        super(items, total);
    }
}
