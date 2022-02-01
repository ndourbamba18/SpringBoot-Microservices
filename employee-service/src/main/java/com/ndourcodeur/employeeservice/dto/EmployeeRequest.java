package com.ndourcodeur.employeeservice.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class EmployeeRequest {

    private Long id;
    @NotBlank
    @Size
    private String firstName;
    @NotBlank
    @Size
    private String lastName;
    @NotBlank
    @Size
    @Email
    private String email;
    @NotBlank
    @Size(max = 25)
    private String phone;
    @NotBlank
    @Size
    private String jobTitle;
    @NotBlank
    @Size
    private String address;

    private Long departmentId;
}
