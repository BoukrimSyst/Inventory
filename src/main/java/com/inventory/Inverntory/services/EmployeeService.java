package com.inventory.Inverntory.services;

import com.inventory.Inverntory.models.Employee;
import com.inventory.Inverntory.repositories.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;
import java.util.Optional;


@Service
public class EmployeeService {
    @Autowired
    private final EmployeeRepository employeeRepository;


    public EmployeeService(com.inventory.Inverntory.repositories.EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    public List<Employee> getAllEmployees() {
        return employeeRepository.findAll();
    }

    public Optional<Employee> getEmployeeById(Long id) {
        return employeeRepository.getEmployeeById(id);
    }


    public Employee addEmployee(Employee employee) {
        return employeeRepository.save(employee);
    }

    public void  removeEmployee(Long id) {
        employeeRepository.removeEmployeeById(id);
    }

    public Optional<Employee> updateEmployee(Long id,Employee employee) {

        Optional<Employee> existingEmployee = employeeRepository.findById(id);
        if (existingEmployee.isPresent()) {
            Employee updatedEmployee = existingEmployee.get();
            updatedEmployee.setName(employee.getName());
            updatedEmployee.setEmail(employee.getEmail());
            updatedEmployee.setJobTitle(employee.getJobTitle());
            updatedEmployee.setPhone(employee.getPhone());
            updatedEmployee.setImageUrl(employee.getImageUrl());
            employeeRepository.save(updatedEmployee);
        }
        return existingEmployee;
    }
}



























