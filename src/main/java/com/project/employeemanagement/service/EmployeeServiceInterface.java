package com.project.employeemanagement.service;

import com.project.employeemanagement.model.EmployeeModel;

import java.util.List;
import java.util.Optional;

public interface EmployeeServiceInterface {
    public EmployeeModel saveEmployee(EmployeeModel employee);
    public Optional<EmployeeModel> getEmployeeById(int id);
    List<EmployeeModel> getAllEmployee();
    EmployeeModel updateEmployee(int id, EmployeeModel employee);
    void deleteEmployee(int id);
}
