package com.inventory.Inverntory.controllers;


import com.inventory.Inverntory.models.Employee;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import com.inventory.Inverntory.services.EmployeeService;

import java.util.List;
import java.util.Optional;

@RestController
@Configuration
@EnableWebMvc
@RequestMapping("/Employee")
public class EmployeeController {
    private final EmployeeService employeeService;

    public EmployeeController(com.inventory.Inverntory.services.EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping("/all")
    public List<Employee> getAllEmployees(){
        return employeeService.getAllEmployees();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Employee> findEmployeeById(@PathVariable Long id){
        Employee employee = employeeService.getEmployeeById(id).orElse(null);
        if (employee == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(employee);
    }


    @PostMapping()
    public ResponseEntity<Employee> addEmployee(@RequestBody Employee employee){
        Employee newEmployee = employeeService.addEmployee(employee);
        return ResponseEntity.ok(newEmployee);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> removeEmployee(@PathVariable Long id){
        employeeService.removeEmployee(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Employee> updateEmployee(@PathVariable Long id, @RequestBody Employee employee){
        Optional<Employee> updatedEmployee = employeeService.updateEmployee(id, employee);
        if (!updatedEmployee.isPresent()) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(updatedEmployee.get());
    }
}






























