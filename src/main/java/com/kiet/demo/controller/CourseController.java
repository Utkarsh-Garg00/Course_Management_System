package com.kiet.demo.controller;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kiet.demo.model.Course;
import com.kiet.demo.service.CourseService;

@RestController
@RequestMapping("/api/courses")
public class CourseController {

    private final CourseService service;

    public CourseController(CourseService service) {
        this.service = service;
    }

    // GET /courses
    @GetMapping("/courses")
    public List<Course> getAllCourses() {
        return service.retrieveAllCourses();
    }

    // GET /course/{id}
    @GetMapping("/course/{id}")
    public Course getCourseById(@PathVariable int id) {
        return service.retrieveCourseById(id);
    }

    // GET /courses/instructor/{name}
    @GetMapping("/courses/instructor/{name}")
    public List<Course> getCoursesByInstructor(@PathVariable String name) {
        return service.retrieveCoursesByInstructor(name);
    }

    // POST /course
    @PostMapping("/course")
    public Course insertCourse(@RequestBody Course course) {
        return service.saveCourse(course);
    }

    // PUT /course/{id}
    @PutMapping("/course/{id}")
    public Course updateCourse(@PathVariable int id, @RequestBody Course course) {
        course.setId(id);
        return service.saveCourse(course);
    }

    // DELETE /course/{id}
    @DeleteMapping("/course/{id}")
    public void removeCourse(@PathVariable int id) {
        service.removeById(id);
    }
}
