package com.kiet.demo.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.kiet.demo.model.Course;
import com.kiet.demo.repository.CourseRepository;

@Service
public class CourseService {

    private final CourseRepository repository;

    public CourseService(CourseRepository repository) {
        this.repository = repository;
    }

    public List<Course> retrieveAllCourses() {
        return repository.findAll();
    }

    public Course retrieveCourseById(int id) {
        return repository.findById(id).orElse(null);
    }

    public List<Course> retrieveCoursesByInstructor(String instructor) {
        return repository.findByInstructor(instructor);
    }

    public Course saveCourse(Course course) {
        return repository.save(course);
    }

    public void removeById(int id) {
        repository.deleteById(id);
    }
}
