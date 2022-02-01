package com.ndourcodeur.departmentservice.repository;

import com.ndourcodeur.departmentservice.entity.Department;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DepartmentRepository extends JpaRepository<Department, Long> {

    public Department findByDepartmentName(String departmentName);

    public boolean existsByDepartmentName(String departmentName);
}
