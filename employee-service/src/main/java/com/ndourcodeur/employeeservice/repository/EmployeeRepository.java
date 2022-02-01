package com.ndourcodeur.employeeservice.repository;

import com.ndourcodeur.employeeservice.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {

    public Employee findByEmailContaining(String email);

    public boolean existsByEmail(String email);
}
