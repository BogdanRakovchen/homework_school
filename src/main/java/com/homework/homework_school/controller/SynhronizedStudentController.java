package com.homework.homework_school.controller;

import com.homework.homework_school.service.StudentService;
import com.homework.homework_school.service.SynhronizedStudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/students")
public class SynhronizedStudentController {

    @Autowired
    private SynhronizedStudentService studentService;

    @GetMapping("/outputStreamSynh")
    public void outputNameOfStudentsStream() {



        studentService.firstStudents();

        studentService.output();
    }
}
