package com.ndourcodeur.employeeservice.payload;

import com.ndourcodeur.employeeservice.entity.Employee;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class ResponseTemplate {

    private Employee employee;
    private Department department;
}
