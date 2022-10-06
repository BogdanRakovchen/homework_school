package com.homework.homework_school.controller;

import com.homework.homework_school.model.Student;
import com.homework.homework_school.service.StudentService;
import org.springframework.web.bind.annotation.*;

import java.util.stream.Stream;

@RestController
@RequestMapping("/students")
public class StudentController {

    private final StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @PostMapping
    public Student createStudent(@RequestBody Student student) {

        return studentService.createStudent(student);
    }

    @GetMapping("/student")
    public Student getStudent(@RequestParam Long id) {
        return studentService.getStudent(id);
    }

    @GetMapping()
    public Student getAllStudentOfAge(int age) {

        return studentService.getAllStudent(age);
    }

    @PutMapping
    public Student updateStudent(@RequestBody Student student) {
        return studentService.updateStudent(student.getId(), student);
    }

    @DeleteMapping("/student")
    public void deleteStudent(@RequestParam Long id) {
        studentService.deleteStudent(id);
    }






}
