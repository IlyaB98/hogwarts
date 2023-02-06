package ru.hogwarts.school.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import ru.hogwarts.school.model.Student;

import java.util.Collection;

public interface StudentRepository extends JpaRepository<Student, Long> {
    Collection<Student> findByAgeBetween(int ageMin, int ageMax);

    Collection<Student> findAllByAge(int age);

    @Query(value = "SELECT COUNT(*) as count FROM student", nativeQuery = true)
    Integer getCountStudents();

    @Query(value = "SELECT AVG(age) as avg_age FROM student", nativeQuery = true)
    Integer getAverageAge();

    @Query(value = "SELECT * FROM student ORDER BY  id DESC limit 5", nativeQuery = true)
    Collection<Student> getLatestStudents();

}
