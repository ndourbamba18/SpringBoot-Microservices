package com.ndourcodeur.departmentservice.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class DepartmentRequest {

    private Long departmentId;
    @NotBlank
    private String departmentName;
    private String departmentLocation;
}
