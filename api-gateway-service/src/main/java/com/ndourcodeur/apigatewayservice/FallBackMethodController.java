package com.ndourcodeur.apigatewayservice;

import org.springframework.web.bind.annotation.*;

@RestController
public class FallBackMethodController {

    // Employee Service
    @GetMapping("/employeeServiceFallBack")
    public String getEmployeeServiceFallBackMethod() {
        return "Employee Service is taking longer than Expected." +
                " Please try again later";
    }

    @PostMapping(path = "/employeeServiceFallBack")
    public String postEmployeeServiceFallBackMethod() {
        return "Employee Service is taking longer than Expected." +
                " Please try again later";
    }

    @PutMapping(path = "/employeeServiceFallBack")
    public String putEmployeeServiceFallBackMethod() {
        return "Employee Service is taking longer than Expected." +
                " Please try again later";
    }

    @DeleteMapping(path = "/employeeServiceFallBack")
    public String deleteEmployeeServiceFallBackMethod() {
        return "Employee Service is taking longer than Expected." +
                " Please try again later";
    }

    // Department Service
    @GetMapping("/departmentServiceFallBack")
    public String userServiceFallBackMethod() {
        return "Department Service is taking longer than Expected." +
                " Please try again later";
    }

    @PostMapping(path = "/departmentServiceFallBack")
    public String postDepartmentServiceFallBackMethod() {
        return "Department Service is taking longer than Expected." +
                " Please try again later";
    }

    @PutMapping(path = "/departmentServiceFallBack")
    public String putDepartmentServiceFallBackMethod() {
        return "Department Service is taking longer than Expected." +
                " Please try again later";
    }

    @DeleteMapping(path = "/departmentServiceFallBack")
    public String deleteDepartmentServiceFallBackMethod() {
        return "Department Service is taking longer than Expected." +
                " Please try again later";
    }

}
