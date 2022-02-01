package com.ndourcodeur.departmentservice.controller;

import com.ndourcodeur.departmentservice.dto.DepartmentRequest;
import com.ndourcodeur.departmentservice.entity.Department;
import com.ndourcodeur.departmentservice.message.Message;
import com.ndourcodeur.departmentservice.services.DepartmentService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping(path = "/api/v1/departments")
public class DepartmentResource {

    private final DepartmentService departmentService;

    public DepartmentResource(DepartmentService departmentService) {
        this.departmentService = departmentService;
    }

    @PostMapping(path = "/add")
    public ResponseEntity<?> addNewDepartment(@Valid @RequestBody DepartmentRequest request){
        if (departmentService.existsDepartmentName(request.getDepartmentName()))
            return new ResponseEntity<>(new Message("Department Name already exist!"), HttpStatus.BAD_REQUEST);
        return new ResponseEntity<>(departmentService.addDepartment(request), HttpStatus.CREATED);
    }

    @PutMapping(path = "/{id}")
    public ResponseEntity<?> updateDepartmentById(@PathVariable Long id, @Valid @RequestBody DepartmentRequest request){
        if (departmentService.existsDepartmentName(request.getDepartmentName()) && departmentService.findDepartmentName(request.getDepartmentName()).getDepartmentId() != id)
            return new ResponseEntity<>(new Message("Department Name already exist!"), HttpStatus.BAD_REQUEST);
        return new ResponseEntity<>(departmentService.editDepartment(id, request), HttpStatus.CREATED);
    }

    @GetMapping(path = "/all")
    public ResponseEntity<?> fetchAllDepartments(){
        List<Department> departments = departmentService.findAllDepartments();
        if (departments.isEmpty())
            return new ResponseEntity<>(new Message("Sorry, No Content Here"), HttpStatus.BAD_REQUEST);
        return new ResponseEntity<>(departments, HttpStatus.OK);
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<?> fetchEmployeeById(@PathVariable Long id){
        return new ResponseEntity<>(departmentService.findDepartment(id), HttpStatus.OK);
    }

    @DeleteMapping(path = "/{id}")
    public ResponseEntity<?> deleteEmployeeById(@PathVariable Long id){
        departmentService.deleteDepartment(id);
        return new ResponseEntity<>(new Message("Department deleted successfully with ID:"+id), HttpStatus.OK);
    }
}
