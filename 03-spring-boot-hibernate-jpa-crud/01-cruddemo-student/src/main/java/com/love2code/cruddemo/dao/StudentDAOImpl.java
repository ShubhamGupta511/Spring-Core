package com.love2code.cruddemo.dao;

import com.love2code.cruddemo.entity.Student;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class StudentDAOImpl implements StudentDAO{

    //define field for the enetity manager

    private EntityManager entityManager;


    // inject entity manager using constructor injection


    @Autowired
    public StudentDAOImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    // implement the save methods
    @Override
    @Transactional
    public void save(Student theStudent) {
       entityManager.persist(theStudent);
    }

    @Override
    public Student findById(Integer id) {
        return entityManager.find(Student.class,id);
    }

    @Override
    public List<Student> findAll() {
        // create query
        TypedQuery<Student> theQuery=entityManager.createQuery("FROM Student order by lastName desc", Student.class);

        // return Query results
        return theQuery.getResultList();
    }
}
