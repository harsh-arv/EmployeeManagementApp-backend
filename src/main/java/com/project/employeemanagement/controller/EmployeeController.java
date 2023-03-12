package com.project.employeemanagement.controller;

import com.project.employeemanagement.model.EmployeeModel;
import com.project.employeemanagement.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/employee")
@CrossOrigin("*")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService; //we are bringing in Employee Service instance

    /**This is a post Request, here we are gonna ba saving an employee*/
    @PostMapping
    public EmployeeModel saveEmployee(@RequestBody EmployeeModel employee){
        return employeeService.saveEmployee(employee);
    }

    /** Here, we are getting all employee*/
    @GetMapping
    public List<EmployeeModel> getAllEmployee(){
        return employeeService.getAllEmployee();
    }

     /**here, we are getting one employee*/

    @GetMapping("/{id}")
    public Optional<EmployeeModel> getEmployeeById(@PathVariable int id){
        return employeeService.getEmployeeById(id);
    }
        /**here, we get going to be updating an employee*/
    @PutMapping("/{id}")
    public EmployeeModel updateEmployee(@PathVariable int id, @RequestBody EmployeeModel employee) {
        return employeeService.updateEmployee(id, employee);
    }

      /**Here, we are going to be deleting an employee*/
    @DeleteMapping("/{id}")
    public void deleteEmployee(@PathVariable int id){
        employeeService.deleteEmployee(id);
    }
}
