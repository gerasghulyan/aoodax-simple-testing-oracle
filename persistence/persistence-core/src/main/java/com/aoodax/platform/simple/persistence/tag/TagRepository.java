package com.aoodax.platform.simple.persistence.tag;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface TagRepository extends JpaRepository<TagEntity, Long>, CustomizedTagRepository {

    Optional<TagEntity> findByUuid(String uid);

    Optional<TagEntity> findByName(String name);

    Optional<TagEntity> findByNameIgnoreCase(String name);
    
}