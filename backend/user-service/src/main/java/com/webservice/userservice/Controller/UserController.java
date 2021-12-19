package com.webservice.userservice.Controller;

import com.webservice.userservice.Model.Professor;
import com.webservice.userservice.Model.Student;
import com.webservice.userservice.Model.User;
import com.webservice.userservice.Service.UserService;
import com.webservice.userservice.VO.ResponseTemplateVO;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/users")
public class UserController {
    private final UserService userService;

    @PostMapping("/prof/register")
    public ResponseEntity<User> registerProfessor(@RequestBody final Professor professor) {
        return new ResponseEntity<>(this.userService.registerProfessor(professor), HttpStatus.OK);
    }

    @PostMapping("/student/register")
    public ResponseEntity<User> registerStudent(@RequestBody final Student student) {
        return new ResponseEntity<>(this.userService.registerStudent(student), HttpStatus.OK);
    }

    @GetMapping(value = "/prof/{regNumber}")
    public ResponseEntity<Professor> getProfessor(@PathVariable final String regNumber) {
        return new ResponseEntity<>(this.userService.getProfessor(regNumber), HttpStatus.OK);
    }

    @GetMapping(value = "/student/{cin}")
    public ResponseEntity<Student> getStudent(@PathVariable final String cin) {
        return new ResponseEntity<>(this.userService.getStudent(cin), HttpStatus.OK);
    }

    @GetMapping(value = "/professors")
    public ResponseEntity<List<Professor>> getProfessors() {
        return new ResponseEntity<>(this.userService.getProfessors(), HttpStatus.OK);
    }

    @GetMapping(value = "/students")
    public ResponseEntity<List<Student>> getStudents() {
        return new ResponseEntity<>(this.userService.getStudents(), HttpStatus.OK);
    }

    @GetMapping(value = "/{userId}")
    public ResponseEntity<ResponseTemplateVO> getUserWithDepartment(@PathVariable final Long userId) throws Exception {
        return new ResponseEntity<>(this.userService.getUserWithDepartment(userId), HttpStatus.OK);
    }
}
