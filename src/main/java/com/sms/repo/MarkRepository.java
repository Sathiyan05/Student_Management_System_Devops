package com.sms.repo;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.sms.model.Mark;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;

@Repository
public class MarkRepository {

    @PersistenceContext
    private EntityManager entityManager;

    @Transactional
    public void save(Mark mark) {
        entityManager.persist(mark);
    }

    public List<Mark> findAll() {
        return entityManager.createQuery("SELECT m FROM Mark m", Mark.class).getResultList();
    }
}