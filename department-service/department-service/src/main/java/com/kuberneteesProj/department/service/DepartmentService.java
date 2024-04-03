package com.kuberneteesProj.department.service;

import com.kuberneteesProj.department.entity.Department;
import com.kuberneteesProj.department.repository.DepartmentRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class DepartmentService {
    @Autowired
    private DepartmentRepository departmentRepository;

    public Department saveDepartment(Department department) {
        log.info("saveDepartment method service");
        return departmentRepository.save(department);
    }

    public Department findByDepartmentId(Long departmentId) {
        log.info("findDepartmentById method service");
        return departmentRepository.findByDepartmentId(departmentId);

    }
}
