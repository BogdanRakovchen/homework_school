package com.homework.homework_school.controller;

import com.homework.homework_school.model.Faculty;
import com.homework.homework_school.service.FacultyService;
import org.springframework.web.bind.annotation.*;

import java.util.stream.Stream;

@RestController
@RequestMapping("faculty")
public class FacultyController {
    private final FacultyService facultyService;

    public FacultyController(FacultyService facultyService) {
        this.facultyService = facultyService;
    }

    @PostMapping
    public Faculty createFaculty(@RequestBody Faculty faculty) {
        return facultyService.createFaculty(faculty);
    }

    @GetMapping({"id"})
    public Faculty getFaculty(Long id) {
        return facultyService.getFaculty(id);
    }
    @GetMapping()
    public Stream<Faculty> getAllFacultyOfColor(String color) {

        return facultyService.getAllFaculty(color);
    }



    @PutMapping
    public Faculty updateFaculty(@RequestBody Faculty faculty) {
        return facultyService.updateFaculty(faculty.getId(), faculty);
    }

    @DeleteMapping({"id"})
    public Faculty deleteFaculty(Long id) {
        return facultyService.deleteFaculty(id);
    }
}