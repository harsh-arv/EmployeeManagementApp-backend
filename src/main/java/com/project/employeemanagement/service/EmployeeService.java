package com.project.employeemanagement.service;

import com.project.employeemanagement.model.EmployeeModel;
import com.project.employeemanagement.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeService implements EmployeeServiceInterface {

    @Autowired
    private EmployeeRepository employeeRepository;

    @Override
    public EmployeeModel saveEmployee(EmployeeModel employee) {
        return employeeRepository.save(employee);
    }

    @Override
    public Optional<EmployeeModel> getEmployeeById(int id) {
        return employeeRepository.findById(id);
    }

    @Override
    public List<EmployeeModel> getAllEmployee() {
        return employeeRepository.findAll(Sort.by(Sort.Direction.DESC, "id"));
    }

    @Override
    public EmployeeModel updateEmployee(int id, EmployeeModel employee) {
        EmployeeModel employeeToUpdate = employeeRepository.findById(id).orElseThrow();
        employeeToUpdate.setFirstName(employee.getFirstName());
        employeeToUpdate.setLastName(employee.getLastName());
        employeeToUpdate.setEmail(employee.getEmail());
        return employeeRepository.save(employeeToUpdate);
    }

    @Override
    public void deleteEmployee(int id) {
        employeeRepository.deleteById(id);
    }
}
