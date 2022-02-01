package com.ndourcodeur.employeeservice.services;

import com.ndourcodeur.employeeservice.dto.EmployeeRequest;
import com.ndourcodeur.employeeservice.entity.Employee;
import com.ndourcodeur.employeeservice.exception.ResourceNotFoundException;
import com.ndourcodeur.employeeservice.payload.Department;
import com.ndourcodeur.employeeservice.payload.ResponseTemplate;
import com.ndourcodeur.employeeservice.repository.EmployeeRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Component
@Slf4j
public class EmployeeServiceImpl implements EmployeeService{

    @Autowired
    private RestTemplate restTemplate;
    private final EmployeeRepository employeeRepository;

    public EmployeeServiceImpl(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    @Override
    public Employee addEmployee(EmployeeRequest request) {
        log.info("Inside addEmployee of EmployeeService");
        Employee employee = new Employee();
        employee.setId(request.getId());
        employee.setFirstName(request.getFirstName());
        employee.setLastName(request.getLastName());
        employee.setEmail(request.getEmail());
        employee.setPhone(request.getPhone());
        employee.setJobTitle(request.getJobTitle());
        employee.setAddress(request.getAddress());
        employee.setDepartmentId(request.getDepartmentId());
        return employeeRepository.save(employee);
    }

    @Override
    public Employee editEmployee(Long id, EmployeeRequest request) {
        log.info("Inside editEmployee of EmployeeService");
        Employee employee = employeeRepository.findById(id)
                .orElseThrow( () -> new ResourceNotFoundException("Employee not found with ID:"+id));
        employee.setId(request.getId());
        employee.setFirstName(request.getFirstName());
        employee.setLastName(request.getLastName());
        employee.setEmail(request.getEmail());
        employee.setPhone(request.getPhone());
        employee.setJobTitle(request.getJobTitle());
        employee.setAddress(request.getAddress());
        employee.setDepartmentId(request.getDepartmentId());
        return employeeRepository.save(employee);
    }

    @Override
    public List<Employee> findAllEmployees() {
        log.info("Inside findAllEmployee of EmployeeService");
        return employeeRepository.findAll();
    }

    @Override
    public Employee findEmployee(Long id) {
        log.info("Inside findEmployee of EmployeeService");
        return employeeRepository.findById(id)
                .orElseThrow( () -> new ResourceNotFoundException("Employee not found with ID:"+id));
    }

    @Override
    public void deleteEmployee(Long id) {
        log.info("Inside deleteEmployee of EmployeeService");
        Employee existEmployee = employeeRepository.findById(id)
                .orElseThrow( () -> new ResourceNotFoundException("Employee not found with ID:"+id));
        employeeRepository.delete(existEmployee);
    }

    @Override
    public ResponseTemplate findEmployeeWithDepartment(Long employeeId) {
        log.info("Inside findEmployeeWithDepartment of EmployeeService");
        ResponseTemplate response = new ResponseTemplate();
        Employee employee = employeeRepository.findById(employeeId)
                .orElseThrow( () -> new ResourceNotFoundException("Employee not exist with ID:"+employeeId));
        Department department = restTemplate.getForObject("http://localhost:8200/api/v1/departments/" + employee.getDepartmentId(), Department.class);
        response.setEmployee(employee);
        response.setDepartment(department);
        return response;
    }

    @Override
    public Employee findEmail(String email) {
        return employeeRepository.findByEmailContaining(email);
    }

    @Override
    public Boolean existsEmail(String email) {
        return employeeRepository.existsByEmail(email);
    }
}
