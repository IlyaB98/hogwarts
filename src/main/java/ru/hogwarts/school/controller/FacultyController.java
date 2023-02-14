package ru.hogwarts.school.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.hogwarts.school.model.Faculty;
import ru.hogwarts.school.model.Student;
import ru.hogwarts.school.service.FacultyService;

import java.util.Collection;
import java.util.List;

@RestController
@RequestMapping("faculty")
public class FacultyController {
    private final FacultyService facultyService;

    public FacultyController(FacultyService facultyService) {
        this.facultyService = facultyService;
    }

    @GetMapping({"{id}"})
    public Faculty getFaculty(@PathVariable long id) {
        return facultyService.findFaculty(id);
    }

    @PostMapping
    public Faculty createFaculty(@RequestBody Faculty faculty) {
        return facultyService.createFaculty(faculty);
    }

    @PutMapping
    public Faculty editFaculty(@RequestBody Faculty faculty) {
        return facultyService.editFaculty(faculty);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Faculty> deleteFaculty(@PathVariable long id) {
        facultyService.deleteFaculty(id);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/color/{color}")
    public Faculty filterBuColorFaculty(@PathVariable String color) {
        return facultyService.findByColor(color);
    }

    @GetMapping("find")
    public ResponseEntity<Faculty> findByColorOrName(@RequestParam(required = false) String color,
                                                     @RequestParam(required = false) String name) {
        if (color != null && !color.isBlank()) {
            return ResponseEntity.ok(facultyService.findByColor(color));
        } else {
            return ResponseEntity.ok(facultyService.findByName(name));
        }
    }

    @GetMapping("/students")
    public Collection<Student> getStudentByFaculty(@RequestParam long facultyId) {
        return facultyService.getStudents(facultyId);
    }

    @GetMapping("/longest-name")
    public String getLongestName() {
        return facultyService.getLongestName();
    }

    @GetMapping("/hw-4.5.4")
    public int sumIterate() {
        return facultyService.sumIterate();
    }
}
