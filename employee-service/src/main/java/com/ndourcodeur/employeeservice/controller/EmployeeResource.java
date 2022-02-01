package com.ndourcodeur.employeeservice.controller;

import com.ndourcodeur.employeeservice.dto.EmployeeRequest;
import com.ndourcodeur.employeeservice.entity.Employee;
import com.ndourcodeur.employeeservice.message.Message;
import com.ndourcodeur.employeeservice.services.EmployeeService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.ws.rs.Path;
import java.util.List;

@RestController
@RequestMapping(path = "/api/v1/employees")
@CrossOrigin(origins = "*")
public class EmployeeResource {

    private final EmployeeService employeeService;

    public EmployeeResource(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @PostMapping(path = "/add")
    public ResponseEntity<?> addNewEmployee(@Valid @RequestBody EmployeeRequest request){
        if (employeeService.existsEmail(request.getEmail()))
            return new ResponseEntity<>(new Message("Email already exist!"), HttpStatus.BAD_REQUEST);
        return new ResponseEntity<>(employeeService.addEmployee(request), HttpStatus.CREATED);
    }

    @PutMapping(path = "/{id}")
    public ResponseEntity<?> updateEmployeeById(@PathVariable Long id, @Valid @RequestBody EmployeeRequest request){
        if (employeeService.existsEmail(request.getEmail()) && employeeService.findEmail(request.getEmail()).getId() != id)
            return new ResponseEntity<>(new Message("Email already exist!"), HttpStatus.BAD_REQUEST);
        return new ResponseEntity<>(employeeService.editEmployee(id, request), HttpStatus.CREATED);
    }

    @GetMapping(path = "/all")
    public ResponseEntity<?> fetchAllEmployees(){
        List<Employee> employees = employeeService.findAllEmployees();
        if (employees.isEmpty())
            return new ResponseEntity<>(new Message("Sorry, No Content Here!"), HttpStatus.BAD_REQUEST);
        return new ResponseEntity<>(employees, HttpStatus.OK);
    }

    /*
    @GetMapping(path = "/{id}")
    public ResponseEntity<?> fetchEmployeeById(@PathVariable Long id){
        return new ResponseEntity<>(employeeService.findEmployee(id), HttpStatus.OK);
    }
     */

    @GetMapping(path = "/{id}")
    public ResponseEntity<?> fetchEmployeeWithDepartmentById(@PathVariable Long id){
        return new ResponseEntity<>(employeeService.findEmployeeWithDepartment(id), HttpStatus.OK);
    }

    @DeleteMapping(path = "/{id}")
    public ResponseEntity<?> deleteEmployeeById(@PathVariable Long id){
        employeeService.deleteEmployee(id);
        return new ResponseEntity<>(new Message("Employee deleted successfully with ID:"+id), HttpStatus.OK);
    }
}
