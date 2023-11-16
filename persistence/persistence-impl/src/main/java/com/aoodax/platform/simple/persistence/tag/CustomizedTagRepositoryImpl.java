package com.aoodax.platform.simple.persistence.tag;

import jakarta.persistence.EntityManager;
import jakarta.persistence.ParameterMode;
import jakarta.persistence.PersistenceContext;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.util.List;

import static com.aoodax.jvm.common.utils.validation.ParameterValidator.assertNotNullParameterArgument;

@Slf4j
@Repository
public class CustomizedTagRepositoryImpl implements CustomizedTagRepository {

    @PersistenceContext
    EntityManager entityManager;

    @Override
    public Page<TagEntity> find(final Pageable pageable) {
        assertNotNullParameterArgument(pageable, "pageable");

        log.debug("Executing get tags method with page info - {}", pageable);
        final List<TagEntity> resultList = entityManager.createQuery("SELECT e FROM TAG e", TagEntity.class)
                .setFirstResult(pageable.getPageNumber() * pageable.getPageSize())
                .setMaxResults(pageable.getPageSize())
                .getResultList();
        final Long totalRecords = entityManager.createQuery("SELECT COUNT(e) FROM TAG e", Long.class)
                .getSingleResult();
        log.debug("Successfully executed get tags with page info - {}", pageable);
        return new PageImpl<>(resultList, PageRequest.of(pageable.getPageNumber(), pageable.getPageSize()), totalRecords);
    }

    @Override
    @SuppressWarnings("unchecked")
    public List<TagEntity> customFindByProc(final Long id) {
        return entityManager.createStoredProcedureQuery("TEST_GET_TAG_BY_ID_PROC", TagEntity.class)
                .registerStoredProcedureParameter("tagId", Long.class, ParameterMode.IN)
                .registerStoredProcedureParameter("cursor_out", ResultSet.class, ParameterMode.REF_CURSOR)
                .setParameter("tagId", id).getResultList();
    }
}