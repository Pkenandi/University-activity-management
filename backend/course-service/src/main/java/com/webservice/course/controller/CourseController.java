package com.webservice.course.controller;

import com.webservice.course.model.Course;
import com.webservice.course.service.CourseService;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.http.HttpStatus.*;

@AllArgsConstructor
@Data
@RestController
@RequestMapping("/courses")
public class CourseController {
    private final CourseService courseService;

    @PostMapping(value = "/add")
    public ResponseEntity<Course> saveCourse(@RequestBody final Course course) throws Exception {
        return new ResponseEntity<>(this.courseService.addCourse(course), CREATED);
    }

    @GetMapping(value = "/get/{courseId}")
    public ResponseEntity<Course> getCourse(@PathVariable final Long courseId) throws Exception {
        return new ResponseEntity<>(this.courseService.getCourseById(courseId), OK);
    }

    @GetMapping(value = "/getAll")
    public ResponseEntity<List<Course>> getCourses() {
        return new ResponseEntity<>(this.courseService.getCourses(), OK);
    }
}
