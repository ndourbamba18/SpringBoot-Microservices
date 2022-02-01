package com.ndourcodeur.departmentservice.services;

import com.ndourcodeur.departmentservice.dto.DepartmentRequest;
import com.ndourcodeur.departmentservice.entity.Department;
import com.ndourcodeur.departmentservice.exception.ResourceNotFoundException;
import com.ndourcodeur.departmentservice.repository.DepartmentRepository;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class DepartmentServiceImpl implements DepartmentService{
    private final DepartmentRepository departmentRepository;

    public DepartmentServiceImpl(DepartmentRepository departmentRepository) {
        this.departmentRepository = departmentRepository;
    }

    @Override
    public Department addDepartment(DepartmentRequest request) {
        Department department = new Department();
        department.setDepartmentId(request.getDepartmentId());
        department.setDepartmentName(request.getDepartmentName());
        department.setDepartmentLocation(request.getDepartmentLocation());
        return departmentRepository.save(department);
    }

    @Override
    public Department editDepartment(Long id, DepartmentRequest request) {
        Department department = departmentRepository.findById(id)
                .orElseThrow( () -> new ResourceNotFoundException("Department not found with ID:"+id));
        department.setDepartmentId(request.getDepartmentId());
        department.setDepartmentName(request.getDepartmentName());
        department.setDepartmentLocation(request.getDepartmentLocation());
        return departmentRepository.save(department);
    }

    @Override
    public List<Department> findAllDepartments() {
        return departmentRepository.findAll();
    }

    @Override
    public Department findDepartment(Long id) {
        return  departmentRepository.findById(id)
                .orElseThrow( () -> new ResourceNotFoundException("Department not found with ID:"+id));
    }

    @Override
    public void deleteDepartment(Long id) {
        Department existingDepartment = departmentRepository.findById(id)
                .orElseThrow( () -> new ResourceNotFoundException("Department not found with ID:"+id));
        departmentRepository.delete(existingDepartment);
    }

    @Override
    public Department findDepartmentName(String departmentName) {
        return departmentRepository.findByDepartmentName(departmentName);
    }

    @Override
    public Boolean existsDepartmentName(String departmentName) {
        return departmentRepository.existsByDepartmentName(departmentName);
    }
}
