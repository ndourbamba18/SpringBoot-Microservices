package com.ndourcodeur.employeeservice.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Entity
@Table(uniqueConstraints = {@UniqueConstraint(columnNames = "email")})
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Employee extends DateAudit{

    @Id @GeneratedValue
    @Column(nullable = false, updatable = false)
    private Long id;

    @NotBlank(message = "This field is required")
    @Size(max = 50)
    private String firstName;

    @NotBlank(message = "This field is required")
    @Size(max = 50)
    private String lastName;

    @NotBlank(message = "This field is required")
    @Size(max = 180)
    @Email(message = "Enter a email valid")
    private String email;

    @NotBlank(message = "This field is required")
    @Size(max = 25)
    private String phone;

    @NotBlank(message = "This field is required")
    @Size(max = 100)
    private String jobTitle;

    @NotBlank(message = "This field is required")
    @Size(max = 300)
    private String address;

    private Long departmentId;
}
