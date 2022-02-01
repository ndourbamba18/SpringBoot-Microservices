package com.ndourcodeur.employeeservice.payload;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class Department {

    private Long departmentId;
    private String departmentName;
    private String departmentLocation;
}
