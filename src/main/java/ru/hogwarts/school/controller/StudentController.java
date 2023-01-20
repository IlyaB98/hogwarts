package ru.hogwarts.school.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.hogwarts.school.model.Student;
import ru.hogwarts.school.service.StudentService;

import java.util.Collection;

@RestController
@RequestMapping("student")
public class StudentController {
    private final StudentService studentService;
    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping({"{id}"})
    public Student getFaculty(@PathVariable long id) {
        return studentService.findStudent(id);
    }

    @PostMapping
    public Student createFaculty(@RequestBody Student student) {
        return studentService.createStudent(student);
    }

    @PutMapping
    public Student editFaculty(@RequestBody Student student) {
        return studentService.editStudent(student);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Student> deleteFaculty(@PathVariable long id) {
        studentService.deleteStudent(id);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/age/{age}")
    public Collection<Student> filterByAge(@PathVariable int age) {
        return studentService.findAgeStudent(age);
    }
}
