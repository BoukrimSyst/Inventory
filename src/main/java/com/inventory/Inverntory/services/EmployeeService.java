package com.inventory.Inverntory.services;

import com.inventory.Inverntory.models.Employee;
import com.inventory.Inverntory.repositories.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;
import java.util.UUID;


@Service
public class EmployeeService {

    private final EmployeeRepository employeeRepository;


    @Autowired
    public EmployeeService(com.inventory.Inverntory.repositories.EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    public List<Employee> getAllEmployees() {
        return employeeRepository.findAll();
    }

    public Employee getEmployeeById(Long id) {
        return employeeRepository.getEmployeeById(id)
                .orElseThrow(() -> new RuntimeException("Employee by ID "+ id +" was not found !"));
    }


    public Employee addEmployee(Employee employee) {
        employee.setId(Long.valueOf(UUID.randomUUID().toString()));
        return employeeRepository.save(employee);
    }

    public void removeEmployee(Long id) {
        employeeRepository.removeEmployeeById(id);
    }

    public Employee updateEmployee(Employee employee) {
        return employeeRepository.save(employee);
    }
}



























