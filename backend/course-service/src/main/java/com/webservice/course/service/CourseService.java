package com.webservice.course.service;

import com.webservice.course.model.Course;
import com.webservice.course.repository.CourseRepository;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@AllArgsConstructor
@Data
@Transactional
@Service
public class CourseService {
    private final CourseRepository courseRepository;

    public Course addCourse(final Course course) throws Exception {
        return this.courseRepository.save(course);
    }

    public Course getCourseById(final Long courseId) throws Exception {
        return this.courseRepository.findById(courseId).orElseThrow(() -> new Exception(" Course not found "));
    }

    public List<Course> getCourses() {
        return this.courseRepository.findAll();
    }
}
