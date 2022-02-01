package com.ndourcodeur.departmentservice.services;

import com.ndourcodeur.departmentservice.dto.DepartmentRequest;
import com.ndourcodeur.departmentservice.entity.Department;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface DepartmentService {

    Department addDepartment(DepartmentRequest request);
    Department editDepartment(Long id, DepartmentRequest request);
    List<Department> findAllDepartments();
    Department findDepartment(Long id);
    void deleteDepartment(Long id);
    Department findDepartmentName(String departmentName);
    Boolean existsDepartmentName(String departmentName);
}
