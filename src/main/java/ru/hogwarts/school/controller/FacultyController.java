package ru.hogwarts.school.controller;

import org.springframework.web.bind.annotation.*;
import ru.hogwarts.school.model.Faculty;
import ru.hogwarts.school.service.FacultyService;

import java.util.Collection;

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
    public Faculty deleteFaculty(@PathVariable long id) {
        return facultyService.deleteFaculty(id);
    }

    @GetMapping("/color/{color}")
    public Collection<Faculty> filterBuColorFaculty(@PathVariable String color) {
        return facultyService.findColorFaculty(color);
    }
}
