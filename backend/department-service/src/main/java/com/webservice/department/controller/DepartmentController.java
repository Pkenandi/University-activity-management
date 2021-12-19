package com.webservice.department.controller;

import com.webservice.department.model.Department;
import com.webservice.department.service.DepartmentService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@AllArgsConstructor
@RestController
@RequestMapping("/departments")
@Slf4j
public class DepartmentController {
    private final DepartmentService departmentService;

    @PostMapping(value = "/add")
    public ResponseEntity<Department> addDepartment(@RequestBody final Department department) {
        log.info(" Department added");
        return new ResponseEntity<Department>(this.departmentService.addDepartment(department), HttpStatus.OK);
    }

    @GetMapping(value = "/{departmentId}")
    public ResponseEntity<Department> getDepartment(@PathVariable final Long departmentId) throws Exception {
        log.info(" get {} department", departmentId);
        return new ResponseEntity<Department>(this.departmentService.getDepartment(departmentId), HttpStatus.OK);
    }

    @GetMapping(value = "/name/{name}")
    public ResponseEntity<Department> getDepartmentByName(@PathVariable final String name) {
        log.info(" get department by name ");
        return new ResponseEntity<>(this.departmentService.getDepartmentByName(name), HttpStatus.OK);
    }
}
