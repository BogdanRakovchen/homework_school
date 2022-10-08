package com.homework.homework_school.controller;

import com.homework.homework_school.model.Faculty;
import com.homework.homework_school.model.Student;
import com.homework.homework_school.service.FacultyService;
import com.homework.homework_school.service.StudentService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.stream.Stream;

@RestController
@RequestMapping("/students")
public class StudentController {

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

    @GetMapping("/student")
    public Student getStudent(@RequestParam Long id) {
        return studentService.getStudent(id);
    }


    @GetMapping("/facultyStudent")
    public String getFacultyOfStudent(@RequestParam Long id) {
        return studentService.getFacultyOfStudent(id);
    }
//    @GetMapping
    public Student getAllStudentOfAge(int age) {

        return studentService.getAllStudent(age);
    }

//    @GetMapping("/studentsOfFaculty")
//    public Collection<Student> getStudentsOfFaculty(@RequestParam Long id) {
//        return studentService.getStudentsOfFaculty(id);
//    }

    @GetMapping("/studentAge")
    public ResponseEntity<Collection<Student>> getAllStudentOfRangeAge(@RequestParam int minAge, @RequestParam int maxAge) {
        return ResponseEntity.ok(studentService.findByAgeBetween(minAge, maxAge));
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
