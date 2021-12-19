package com.webservice.userservice.Repository;

import com.webservice.userservice.Model.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student, String> {
    Student findStudentByCin(String cin);
}
