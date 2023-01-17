package ru.hogwarts.school.service;

import org.springframework.stereotype.Service;
import ru.hogwarts.school.model.Student;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

@Service
public class StudentService {
    private final Map<Long, Student> studentMap = new HashMap<>();
    private long currentId = 0;

    public Student createStudent(Student student) {
        student.setId(++currentId);
        studentMap.put(currentId, student);
        return student;
    }

    public Student findStudent(long id) {
        return studentMap.get(id);
    }

    public Student editStudent(Student student) {
        studentMap.put(student.getId(), student);
        return student;
    }

    public Student deleteStudent(long id) {
        return studentMap.remove(id);
    }

    public Collection<Student> findAgeStudent(int age) {
        return studentMap.values()
                .stream()
                .filter(s -> s.getAge() == age)
                .toList();
    }
}