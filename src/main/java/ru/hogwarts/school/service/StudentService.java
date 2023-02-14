package ru.hogwarts.school.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import ru.hogwarts.school.model.Faculty;
import ru.hogwarts.school.model.Student;
import ru.hogwarts.school.repositories.StudentRepository;

import java.util.Collection;
import java.util.List;

@Service
public class StudentService {
    private final StudentRepository studentRepository;

    Logger logger = LoggerFactory.getLogger(StudentService.class);

    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public Student createStudent(Student student) {
        logger.info("Create student: {}", student);
        return studentRepository.save(student);
    }

    public Student findStudent(long id) {
        logger.info("Find student by id: {}", id);
        return studentRepository.findById(id).orElse(null);
    }

    public Student editStudent(Student student) {
        logger.info("Was invoked method for student edit {}", student);
        return studentRepository.save(student);
    }

    public void deleteStudent(long id) {
        logger.info("Was invoked method for student delete by id {}", id);
        studentRepository.deleteById(id);
    }

    public Collection<Student> findByAgeBetween(int ageMin, int ageMax) {
        logger.info("Find students by age between {} and {}", ageMin, ageMax);
        return studentRepository.findByAgeBetween(ageMin, ageMax);
    }

    public Collection<Student> findAgeStudent(int age) {
        logger.info("Find students by age {}", age);
        return studentRepository.findAllByAge(age);
    }

    public Faculty getFaculty(long id) {
        logger.info("Find faculty by id student {}", id);
        return studentRepository.findById(id).get().getFaculty();
    }

    public Integer getCountStudents() {
        logger.info("Was invoked method for count students");
        return studentRepository.getCountStudents();
    }

    public Integer getAverageAge() {
        logger.info("Was invoked method for receiving average age");
        return studentRepository.getAverageAge();
    }

    public Collection<Student> getLatestStudents() {
        logger.info("Was invoked method for receiving latest added students");
        return studentRepository.getLatestStudents();
    }

    public List<String> getAllStudentsBeginningWithLetter(char letter) {
        logger.info("Was invoked method for get all students beginning with letter {}", letter);
        return studentRepository.findAll()
                .stream()
                .parallel()
                .map(Student::getName)
                .map(String::toUpperCase)
                .filter(name -> name.charAt(0) == letter ||
                        name.charAt(0) == Character.toUpperCase(letter))
                .sorted()
                .toList();
    }
}
