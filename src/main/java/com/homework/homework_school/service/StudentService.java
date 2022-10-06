package com.homework.homework_school.service;

import com.homework.homework_school.model.Student;
import com.homework.homework_school.repository.StudentRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;



import java.util.List;

@Service
public class StudentService {
    @Autowired
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

    public Student getAllStudent(int age) {
        List<Student> student = studentRepository.findAll();
        for (Student student1 : student) {
            if(student1.getAge() == age) {
                return studentRepository.save(student1);
            }
        }
        return (Student) student;
    }

    public Student updateStudent(Long id, Student student) {
        Student newStudent = studentRepository.findById(id).get();
        return studentRepository.save(newStudent);
    }

    public void deleteStudent(Long id) {
        studentRepository.deleteById(id);

    }



}
