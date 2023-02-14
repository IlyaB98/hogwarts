package ru.hogwarts.school.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import ru.hogwarts.school.model.Faculty;
import ru.hogwarts.school.model.Student;
import ru.hogwarts.school.repositories.FacultyRepository;

import java.util.Collection;

@Service
public class FacultyService {
    private final FacultyRepository facultyRepository;

    Logger logger = LoggerFactory.getLogger(FacultyService.class);

    public FacultyService(FacultyRepository facultyRepository) {
        this.facultyRepository = facultyRepository;
    }

    public Faculty createFaculty(Faculty faculty) {
        logger.info("Create faculty: {}", faculty);
        return facultyRepository.save(faculty);
    }

    public Faculty findFaculty(long id) {
        logger.info("Find faculty by id: {}", id);
        return facultyRepository.findById(id).orElse(null);
    }

    public Faculty editFaculty(Faculty faculty) {
        logger.info("Was invoked method for faculty edit {}", faculty);
        return facultyRepository.save(faculty);
    }

    public void deleteFaculty(long id) {
        logger.info("Delete faculty by id: {}", id);
        facultyRepository.deleteById(id);
    }

    public Faculty findByColor(String color) {
        logger.info("Find faculty by color: {}", color);
        return facultyRepository.findByColorIgnoreCase(color);
    }
    public Faculty findByName(String name) {
        logger.info("Find faculty by name: {}", name);
        return facultyRepository.findByNameIgnoreCase(name);
    }

    public Collection<Student> getStudents(long facultyId) {
        logger.info("Get students for faculty id: {}", facultyId);
        return facultyRepository.getReferenceById(facultyId).getStudents();
    }
}
