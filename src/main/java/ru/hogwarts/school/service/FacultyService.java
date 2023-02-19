package ru.hogwarts.school.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import ru.hogwarts.school.model.Faculty;
import ru.hogwarts.school.model.Student;
import ru.hogwarts.school.repositories.FacultyRepository;

import java.util.Collection;
import java.util.Comparator;
import java.util.stream.Stream;

@Service
public class FacultyService {
    private final FacultyRepository facultyRepository;

    private static final Logger logger = LoggerFactory.getLogger(FacultyService.class);

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

    public String getLongestName() {
        logger.info("Was invoked method for get longest name");

        return facultyRepository.findAll()
                .stream()
                .max(Comparator.comparing(faculty -> faculty.getName().length()))
                .map(Faculty::getName)
                .orElseThrow();
    }

    public long sumIterate() {
        long timeStart = System.currentTimeMillis();
//        long sum = Stream.iterate(1L, a -> a + 1)
//                .limit(1_000_000)
//                .parallel()
//                .reduce(0L, (a, b) -> a + b);

        long sum = ((((1 + 1_000_000) / 2)) * 1_000_000L);

        long time = System.currentTimeMillis() - timeStart;

        logger.info("Method execution time: {} ms", time);
        return sum;
    }
}
