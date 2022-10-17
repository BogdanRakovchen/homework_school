package com.homework.homework_school.service;

import com.homework.homework_school.model.Faculty;
import com.homework.homework_school.model.Student;
import com.homework.homework_school.repository.FacultyRepository;
import com.homework.homework_school.repository.StudentRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;


import java.util.Collection;
import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

@Service
public class StudentService {

    private final StudentRepository studentRepository;

    public StudentService(StudentRepository studentRepository) {

        this.studentRepository = studentRepository;
    }

    public Student createStudent(Student student) {

        return studentRepository.save(student);
    }

    public Student getStudent(Long id) {
        return studentRepository.findById(id).get();

    }

    public Faculty getFacultyOfStudent(Long id) {
        return studentRepository.findById(id).orElse(null).getFaculty();

    }
    
    public Student getAllStudent(int age) {
        List<Student> student = studentRepository.findAll();
        for (Student student1 : student) {
            if(student1.getAge() == age) {
                return studentRepository.save(student1);
            }
        }
        return (Student) student;
    }

    public Collection<Student> findByAgeBetween(int minAge, int maxAge) {
       return studentRepository.findByAgeBetween(minAge, maxAge);
    }

    public Student updateStudent(Long id, Student student) {
        return studentRepository.save(student);
    }

    public void deleteStudent(Long id) {
        studentRepository.deleteById(id);

    }

    public int getAllStudents() {
        return studentRepository.findByAllStudent();
    }

    public int getAvarageAgeAllStudents() {
        return studentRepository.findByAvarageAgeAllStudents();
    }

    public Collection<Student> getFiveLastOfStudents() {
        return studentRepository.findByFiveLastOfStudents();
    }


}
