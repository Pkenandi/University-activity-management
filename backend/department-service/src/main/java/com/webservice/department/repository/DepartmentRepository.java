package com.webservice.department.repository;

import com.webservice.department.model.Department;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DepartmentRepository extends JpaRepository<Department, Long> {
    Department findDepartmentByDepartmentName(final String departmentName);
}
