package com.ndourcodeur.departmentservice.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(uniqueConstraints = {@UniqueConstraint(columnNames = "departmentName")})
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Department extends DateAudit {

    @Id @GeneratedValue
    private Long departmentId;
    private String departmentName;
    private String departmentLocation;
}
