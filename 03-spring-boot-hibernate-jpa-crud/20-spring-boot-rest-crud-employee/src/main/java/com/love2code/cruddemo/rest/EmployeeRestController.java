package com.love2code.cruddemo.rest;


import com.love2code.cruddemo.dao.EmployeeDAO;
import com.love2code.cruddemo.entity.Employee;
import com.love2code.cruddemo.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class EmployeeRestController {
    // Inject the employee DAO Directly
    private EmployeeService employeeService;

    @Autowired
    public EmployeeRestController(EmployeeService employeeService){
        this.employeeService=employeeService;
    }

    // Expose "/employees" and return a list of employees

    @GetMapping("/employees")
    public List<Employee> findAll(){
        return employeeService.findAll();
    }

    @GetMapping("/employees/{employeeId}")
    public Employee getEmployee(@PathVariable int employeeId){
        Employee employee=employeeService.findById(employeeId);

        if(employee==null){
            throw new RuntimeException("Employee id not found-"+employeeId);
        }
        return employee;
    }

    @PostMapping("/employees")
    public Employee addEmployee(@RequestBody Employee employee){
        // aslo just in case thy pass an id in josn ... set the id
        // 0 this is to force the save of new item .. instead of update

        employee.setId(0);

        Employee dbEmployee=employeeService.save(employee);

        return  dbEmployee;


    }

    @PutMapping("/employees")
    public Employee updateEmployee(@RequestBody Employee employee){
        Employee employee1=employeeService.save(employee);

        return employee1;
    }

    @DeleteMapping("/employees/{employeeId}")
    public String deleteEmployee(@PathVariable int employeeId){
        Employee employee=employeeService.findById(employeeId);

        if(employee==null){
            throw new RuntimeException("Employee id not found-"+employeeId);
        }

        employeeService.deleteById(employeeId);

        return "Deleted Employee id-"+employeeId;
    }

}
