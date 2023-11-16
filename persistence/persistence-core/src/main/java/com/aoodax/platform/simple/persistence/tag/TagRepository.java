package com.aoodax.platform.simple.persistence.tag;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.util.Optional;

@Repository
public interface TagRepository extends JpaRepository<TagEntity, Long>, CustomizedTagRepository {

    Optional<TagEntity> findByUuid(String uid);

    Optional<TagEntity> findByName(String name);

    Optional<TagEntity> findByNameIgnoreCase(String name);
    
    @Query(value = "SELECT TEST_GET_TAG_BY_ID_FUNC(:id) FROM DUAL", nativeQuery = true)
    ResultSet getResultSetById(final @Param("id") Long id);
    
}