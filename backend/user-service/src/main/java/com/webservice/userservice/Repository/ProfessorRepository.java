package com.webservice.userservice.Repository;

import com.webservice.userservice.Model.Professor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProfessorRepository extends JpaRepository<Professor, String> {
    Professor findProfessorByRegNumber(String regNumber);
}
