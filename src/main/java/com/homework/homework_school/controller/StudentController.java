package com.homework.homework_school.controller;

import com.homework.homework_school.model.Faculty;
import com.homework.homework_school.model.Student;
import com.homework.homework_school.service.FacultyService;
import com.homework.homework_school.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.stream.Stream;

@RestController
@RequestMapping("/students")
public class StudentController {

    @Autowired
    private final StudentService studentService;
    private final FacultyService facultyService;


    public StudentController(StudentService studentService,
                             FacultyService facultyService) {
        this.studentService = studentService;
        this.facultyService = facultyService;
    }

    @PostMapping
    public Student createStudent(@RequestBody Student student) {

        return studentService.createStudent(student);
    }

    @GetMapping("/{id}")
    public Student getStudent(@PathVariable("id") Long id) {
        return studentService.getStudent(id);
    }


    @GetMapping("/{id}/faculty")
    public Faculty getFacultyOfStudent(@PathVariable("id") Long id) {
        return studentService.getFacultyOfStudent(id);
    }
    public Student getAllStudentOfAge(int age) {

        return studentService.getAllStudent(age);
    }

    @GetMapping("/studentAge")
    public ResponseEntity<Collection<Student>> getAllStudentOfRangeAge(@RequestParam int minAge, @RequestParam int maxAge) {
        return ResponseEntity.ok(studentService.findByAgeBetween(minAge, maxAge));
    }

    @GetMapping("/allStudents")
    public int getAllStudents() {
        return studentService.getAllStudents();
    }

    @GetMapping("/avarage-age-students")
    public int getAvarageAgeAllStudents() {
        return studentService.getAvarageAgeAllStudents();
    }

    @GetMapping("/five-last-students")
    public Collection<Student> getFiveLastOfStudents() {
        return studentService.getFiveLastOfStudents();
    }

    @PutMapping()
    public Student updateStudent(@RequestBody Student student) {
        return studentService.updateStudent(student.getId(), student);
    }

    @DeleteMapping("/{id}")
    public void deleteStudent(@PathVariable("id") Long id) {
        studentService.deleteStudent(id);
    }






}
