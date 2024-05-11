package com.sms.repo;

import java.util.List;

import org.springframework.stereotype.Repository;
import com.sms.model.Subject;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;

@Repository
public class SubjectRepository {

    @PersistenceContext
    private EntityManager entityManager;

    @Transactional
    public void save(Subject sub) {
        entityManager.persist(sub);
    }

    public List<Subject> findAll() {
        return entityManager.createQuery("SELECT sub FROM Subject sub", Subject.class).getResultList();
    }
}