	package com.sms.repo;
	
	import java.util.List;
	
	import org.springframework.stereotype.Repository;
	
	import com.sms.model.Semester;
	
	import jakarta.persistence.EntityManager;
	import jakarta.persistence.PersistenceContext;
	import jakarta.transaction.Transactional;
	
	@Repository
	@Transactional
	public class SemesterRepository {
	
	    @PersistenceContext
	    private EntityManager entityManager;
	
	    @Transactional
	    public void save(Semester sem) {
	        entityManager.persist(sem);
	    }
	
	    public List<Semester> findAll() {
	        return entityManager.createQuery("SELECT sem FROM Semester sem", Semester.class).getResultList();
	    }
	}