package com.aoodax.platform.simple.persistence.tag;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomizedTagRepository {

    Page<TagEntity> find(final Pageable pageable);

}
