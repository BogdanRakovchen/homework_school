package com.homework.homework_school.repository;

import com.homework.homework_school.model.Faculty;
import com.homework.homework_school.model.Student;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.List;


@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {
    Collection<Student> findByAgeBetween(int min, int max);
    @Query(value = "SELECT COUNT(*) FROM student", nativeQuery = true)
    int findByAllStudent();

    @Query(value = "SELECT AVG(age) FROM student", nativeQuery = true)
    int findByAvarageAgeAllStudents();

    @Query(value = "SELECT * FROM student WHERE student.id >= 8 and student.id <= 12", nativeQuery = true)
    Collection<Student> findByFiveLastOfStudents();

}
