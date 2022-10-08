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
import java.util.stream.Stream;

@Service
public class StudentService {
    @Autowired
    private final StudentRepository studentRepository;
    @Autowired
    private final FacultyRepository facultyRepository;
    public StudentService(StudentRepository studentRepository, FacultyRepository facultyRepository) {

        this.studentRepository = studentRepository;
        this.facultyRepository = facultyRepository;
    }

    public Student createStudent(Student student) {

        return studentRepository.save(student);
    }

    public Student getStudent(Long id) {
        return studentRepository.findById(id).get();

    }

    public String getFacultyOfStudent(Long id) {
        String student = studentRepository.findById(id).get().getFaculty().getName();
        System.out.println("student = " + student);
        return student;
    }

//    public Collection<Student> getStudentsOfFaculty(Long id) {
//        Student students = studentRepository.findById(id).get();
//        return students.getFaculty().getStudents();
//    }

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
        Student newStudent = studentRepository.findById(id).get();
        return studentRepository.save(newStudent);
    }

    public void deleteStudent(Long id) {
        studentRepository.deleteById(id);

    }



}
