package com.kiet.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.kiet.demo.model.Course;
import com.kiet.demo.service.CourseService;

@Controller
public class CourseViewController {

    private final CourseService service;

    public CourseViewController(CourseService service) {
        this.service = service;
    }

    // Show all courses
    
    
@GetMapping("/courses")
public String showCourses(Model model) {

    var courses = service.retrieveAllCourses();

    model.addAttribute("courses", courses);
    model.addAttribute("totalCourses", courses.size());

    long instructors = courses.stream()
            .map(c -> c.getInstructor())
            .distinct()
            .count();

    model.addAttribute("totalInstructors", instructors);

    return "index";
}

    // Show add course form
    @GetMapping("/courses/add")
    public String addCoursePage(Model model) {
        model.addAttribute("course", new Course());
        return "course";
    }

    // ✅ ADD THIS: Show update course form
    @GetMapping("/courses/update/{id}")
    public String updateCoursePage(@PathVariable int id, Model model) {
        Course course = service.retrieveCourseById(id);
        model.addAttribute("course", course);
        return "course"; // same form as add, but with data filled
    }

    // ✅ ADD THIS: Handle delete
    @GetMapping("/courses/delete/{id}")
    public String deleteCourse(@PathVariable int id) {
        service.removeById(id);
        return "redirect:/courses"; // redirect back to course list
    }
    
    // Handle form submission
    @PostMapping("/courses/save")
    public String saveCourse(@ModelAttribute Course course) {
        service.saveCourse(course);
        return "redirect:/courses";
    }

    // (Optional) Show course details
    @GetMapping("/courses/{id}")
    public String courseDetails(@PathVariable int id, Model model) {
        model.addAttribute("course", service.retrieveCourseById(id));
        return "details";
    }
}
