package ru.hogwarts.school.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.hogwarts.school.model.Faculty;
import ru.hogwarts.school.model.Student;
import ru.hogwarts.school.service.StudentService;

import java.util.Collection;
import java.util.List;

@RestController
@RequestMapping("student")
public class StudentController {
    private final StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping({"{id}"})
    public Student getStudent(@PathVariable long id) {
        return studentService.findStudent(id);
    }

    @PostMapping
    public Student createStudent(@RequestBody Student student) {
        return studentService.createStudent(student);
    }

    @PutMapping
    public Student editStudent(@RequestBody Student student) {
        return studentService.editStudent(student);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Student> deleteStudent(@PathVariable long id) {
        studentService.deleteStudent(id);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/age/{age}")
    public Collection<Student> filterByAge(@PathVariable int age) {
        return studentService.findAgeStudent(age);
    }

    @GetMapping("age/{min}/{max}")
    public Collection<Student> findByAgeBetween(@PathVariable int min, @PathVariable int max) {
        return studentService.findByAgeBetween(min, max);
    }

    @GetMapping("/faculty")
    public Faculty getFacultyByStudentId(@RequestParam long id) {
        return studentService.getFaculty(id);
    }

    @GetMapping("/all")
    public Integer getAllStudents() {
        return studentService.getCountStudents();
    }

    @GetMapping("/average-age")
    public Integer getAverageAge() {
        return studentService.getAverageAge();
    }
    @GetMapping("/latest-students")
    public Collection<Student> getLatestStudents() {
        return studentService.getLatestStudents();
    }

    @GetMapping("/all-students-beginning-with-a-letter/{letter}")
    public List<String> getAllStudentsBeginningWithLetter(@PathVariable("letter") char letter) {
        return studentService.getAllStudentsBeginningWithLetter(letter);
    }

    @GetMapping("/student-list-stream")
    public void getStudentListStream() {
        studentService.getStudentListStream();
    }
    @GetMapping("/student-list-treads")
    public void getSynchronizedList() {
        studentService.getSynchronizedList();
    }
}
