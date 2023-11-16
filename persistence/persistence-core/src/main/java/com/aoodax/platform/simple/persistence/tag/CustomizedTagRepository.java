package com.aoodax.platform.simple.persistence.tag;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CustomizedTagRepository {

    Page<TagEntity> find(Pageable pageable);

    List<TagEntity> customFindByProc(Long id);

}
