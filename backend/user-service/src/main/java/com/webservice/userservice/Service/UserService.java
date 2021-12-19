package com.webservice.userservice.Service;

import com.webservice.userservice.Model.Professor;
import com.webservice.userservice.Model.Student;
import com.webservice.userservice.Model.User;
import com.webservice.userservice.Repository.ProfessorRepository;
import com.webservice.userservice.Repository.StudentRepository;
import com.webservice.userservice.Repository.UserRepository;
import com.webservice.userservice.VO.Department;
import com.webservice.userservice.VO.ResponseTemplateVO;
import lombok.AllArgsConstructor;
import org.springframework.expression.ExpressionException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.Optional;

@AllArgsConstructor
@Service
@Transactional
public class UserService {
    private final UserRepository userRepository;
    private final StudentRepository studentRepository;
    private final ProfessorRepository professorRepository;

    private final RestTemplate restTemplate;

    public User registerStudent(Student student) {
        return this.userRepository.save(student);
    }

    public User registerProfessor(Professor professor) {
        return this.userRepository.save(professor);
    }

    public Student getStudent(String cin) {
        return this.studentRepository.findStudentByCin(cin);
    }

    public Professor getProfessor(final String regNumber) {
        return this.professorRepository.findProfessorByRegNumber(regNumber);
    }

    public List<Student> getStudents() {
        return this.studentRepository.findAll();
    }

    public List<Professor> getProfessors() {
        return this.professorRepository.findAll();
    }

    public ResponseTemplateVO getUserWithDepartment(final Long userId) throws Exception {
        ResponseTemplateVO templateVO = new ResponseTemplateVO();
        User user = this.userRepository.findById(userId)
                .orElseThrow(() -> new Exception(" User not found"));
        Department department =
                restTemplate.getForObject("http://localhost:8001/departments/name/" + user.getDepartmentName(),
                Department.class);
        return Optional.ofNullable(department)
                .map(dep -> {
                    templateVO.setDepartment(dep);
                    templateVO.setUser(user);
                    return templateVO;
                }).orElse(null);
    }
}
