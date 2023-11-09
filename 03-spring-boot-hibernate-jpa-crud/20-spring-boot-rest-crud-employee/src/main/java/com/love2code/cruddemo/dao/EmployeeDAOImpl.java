package com.love2code.cruddemo.dao;

import com.love2code.cruddemo.entity.Employee;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public class EmployeeDAOImpl implements EmployeeDAO {

    // Define tield for the entityManager
     private EntityManager entityManager;

    // set up the constructor injection
    public EmployeeDAOImpl(EntityManager theEntityManager){
        entityManager=theEntityManager;
    }

    @Override
    public List<Employee> findAll() {

        //create a Query
        TypedQuery<Employee> query=entityManager.createQuery("from Employee", Employee.class);


        //Exceute a query and get results
        List<Employee> employees=query.getResultList();

        // return the results
         return employees;
    }

    @Override
    public Employee findById(int theId) {
        //get the Employee by Id
        Employee employee=entityManager.find(Employee.class,theId);

        // return employee
        return employee;
    }

    @Override
    public Employee save(Employee theEmployee) {
        // Add or Update the employee if id==0
        Employee dbEmployee=entityManager.merge(theEmployee);

        //return the Db employee
        return dbEmployee;

    }

    @Override
    public void deleteById(int theId) {
        // find the employee by the id
        Employee employee=entityManager.find(Employee.class,theId);

        // Remove the employee
        entityManager.remove(employee);

    }
}
