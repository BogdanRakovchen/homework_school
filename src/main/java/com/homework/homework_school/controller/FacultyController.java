package com.homework.homework_school.controller;

import com.homework.homework_school.model.Faculty;
import com.homework.homework_school.service.FacultyService;
import org.springframework.web.bind.annotation.*;


import java.util.stream.Stream;

@RestController
@RequestMapping("facultys")
public class FacultyController {
    private final FacultyService facultyService;

    public FacultyController(FacultyService facultyService) {
        this.facultyService = facultyService;
    }

    @PostMapping
    public Faculty createFaculty(@RequestBody Faculty faculty) {
        return facultyService.createFaculty(faculty);
    }

    @GetMapping("/faculty")
    public Faculty getFaculty(@RequestParam Long id) {
        return facultyService.getFaculty(id);
    }
    @GetMapping()
    public Faculty getAllFacultyOfColor(String color) {

        return facultyService.getAllFaculty(color);
    }



    @PutMapping
    public Faculty updateFaculty(@RequestBody Faculty faculty) {
        return facultyService.updateFaculty(faculty.getId(), faculty);
    }

    @DeleteMapping("/faculty")
    public void deleteFaculty(@RequestParam Long id) {
         facultyService.deleteFaculty(id);
    }
}
