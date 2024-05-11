package com.sms.repo;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.sms.model.Student;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;

@Repository
@Transactional
public class StudentRepository {

    @PersistenceContext
    private EntityManager entityManager;

    @Transactional
    public void save(Student stud) {
        entityManager.persist(stud);
    }

    public List<Student> findAll() {
        return entityManager.createQuery("SELECT stud FROM Student stud", Student.class).getResultList();
    }
}