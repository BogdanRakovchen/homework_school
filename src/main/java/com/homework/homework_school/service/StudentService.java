package com.homework.homework_school.service;

import com.homework.homework_school.model.Faculty;
import com.homework.homework_school.model.Student;
import com.homework.homework_school.repository.FacultyRepository;
import com.homework.homework_school.repository.StudentRepository;

import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.slf4j.LoggerFactory;


import java.util.Collection;
import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

@Service
public class StudentService {

    private final StudentRepository studentRepository;

    private static final Logger logger = LoggerFactory.getLogger(StudentService.class);

    public StudentService(StudentRepository studentRepository) {

        this.studentRepository = studentRepository;
    }

    public Student createStudent(Student student) {
        logger.info("Was invoked method for create student");
        return studentRepository.save(student);
    }

    public Student getStudent(Long id) {
            logger.error("getAvatar равен null");
            logger.info("getStudent show");
        return studentRepository.findById(id).orElse(null).getAvatar().getStudent();


    }

    public Faculty getFacultyOfStudent(Long id) {
        logger.error("There is not student with id = " + id);
        return studentRepository.findById(id).orElse(null).getFaculty();

    }
    
    public Student getAllStudent(int age) {
        logger.info("getAllStudent for age");
        List<Student> student = studentRepository.findAll();
        for (Student student1 : student) {
            if(student1.getAge() == age) {
                return studentRepository.save(student1);
            }
        }
        return (Student) student;
    }

    public Collection<Student> findByAgeBetween(int minAge, int maxAge) {
        logger.info("Collection getAllStudent for minAge and maxAge");
        return studentRepository.findByAgeBetween(minAge, maxAge);
    }

    public Student updateStudent(Long id, Student student) {
        logger.info("updateStudent " + student);

        return studentRepository.save(student);
    }

    public void deleteStudent(Long id) {
        logger.info("updateStudent, id = " + id);
        studentRepository.deleteById(id);

    }

    public int getAllStudents() {
        logger.info("allstudents");
        return studentRepository.findByAllStudent();
    }

    public double getAvarageAgeAllStudents() {
        logger.info("getAvarageAgeAllStudents");
        return studentRepository.findByAvarageAgeAllStudents();
    }

    public Collection<Student> getFiveLastOfStudents() {
        logger.info("getFiveLastOfStudents");
        return studentRepository.findByFiveLastOfStudents();
    }


}
