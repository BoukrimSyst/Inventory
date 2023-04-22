package com.inventory.Inverntory.repositories;

import com.inventory.Inverntory.models.Employee;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;


@Transactional
public interface EmployeeRepository extends JpaRepository<Employee, Long> {

    Optional<Employee> getEmployeeById(Long id);

    void removeEmployeeById(Long id);
}
