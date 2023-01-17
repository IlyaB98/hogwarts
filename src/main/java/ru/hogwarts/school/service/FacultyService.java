package ru.hogwarts.school.service;

import org.springframework.stereotype.Service;
import ru.hogwarts.school.model.Faculty;
import ru.hogwarts.school.model.Student;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

@Service
public class FacultyService {
    private final Map<Long, Faculty> facultyMap = new HashMap<>();
    private long currentId = 0;

    public Faculty createFaculty(Faculty faculty) {
        faculty.setId(++currentId);
        facultyMap.put(currentId, faculty);
        return faculty;
    }

    public Faculty findFaculty(long id) {
        return facultyMap.get(id);
    }

    public Faculty editFaculty(Faculty faculty) {
        facultyMap.put(faculty.getId(), faculty);
        return faculty;
    }

    public Faculty deleteFaculty(long id) {
        return facultyMap.remove(id);
    }

    public Collection<Faculty> findColorFaculty(String color) {
        return facultyMap.values()
                .stream()
                .filter(f -> f.getColor().equals(color))
                .toList();
    }
}
