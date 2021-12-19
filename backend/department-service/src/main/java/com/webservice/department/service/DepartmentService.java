package com.webservice.department.service;

import com.webservice.department.model.Department;
import com.webservice.department.repository.DepartmentRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@AllArgsConstructor
@Service
@Transactional
public class DepartmentService {
    private final DepartmentRepository departmentRepository;

    public Department addDepartment(Department department) {
        if (department != null) {
            return this.departmentRepository.save(department);
        } else {
            return null;
        }
    }

    public Department getDepartment(final Long departmentId) throws Exception {
        return this.departmentRepository.findById(departmentId)
                .orElseThrow(() ->  new Exception(" department not found "));
    }

    public Department getDepartmentByName(final String departmentName) {
        return this.departmentRepository.findDepartmentByDepartmentName(departmentName);
    }
}
