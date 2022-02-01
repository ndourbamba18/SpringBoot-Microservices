package com.ndourcodeur.employeeservice.services;

import com.ndourcodeur.employeeservice.dto.EmployeeRequest;
import com.ndourcodeur.employeeservice.entity.Employee;
import com.ndourcodeur.employeeservice.payload.ResponseTemplate;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface EmployeeService {

    Employee addEmployee(EmployeeRequest request);
    Employee editEmployee(Long id, EmployeeRequest request);
    List<Employee> findAllEmployees();
    Employee findEmployee(Long id);
    void deleteEmployee(Long id);
    ResponseTemplate findEmployeeWithDepartment(Long employeeId);
    Employee findEmail(String email);
    Boolean existsEmail(String email);
}
