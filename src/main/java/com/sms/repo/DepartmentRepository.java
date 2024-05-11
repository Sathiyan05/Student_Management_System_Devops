package com.sms.repo;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.sms.model.Department;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;

@Repository
public class DepartmentRepository {

    @PersistenceContext
    private EntityManager entityManager;

    @Transactional
    public void save(Department dept) {
        entityManager.persist(dept);
    }

    public List<Department> findAll() {
        return entityManager.createQuery("SELECT d FROM Department d", Department.class).getResultList();
    }
}