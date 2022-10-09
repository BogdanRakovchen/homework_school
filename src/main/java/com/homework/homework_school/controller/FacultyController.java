package com.homework.homework_school.controller;

import com.homework.homework_school.model.Faculty;
import com.homework.homework_school.model.Student;
import com.homework.homework_school.service.FacultyService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.Collection;
import java.util.stream.Stream;

@RestController
@RequestMapping("/facultys")
public class FacultyController {
    private final FacultyService facultyService;

    public FacultyController(FacultyService facultyService) {
        this.facultyService = facultyService;
    }

    @PostMapping
    public Faculty createFaculty(@RequestBody Faculty faculty) {
        return facultyService.createFaculty(faculty);
    }

    @GetMapping("/{id}")
    public Faculty getFaculty(@PathVariable("id") Long id) {
        return facultyService.getFaculty(id);
    }
    @GetMapping()
    public Faculty getAllFacultyOfColor(String color) {

        return facultyService.getAllFaculty(color);
    }

    @GetMapping("/{id}")
    public Collection<Student> getStudentsOfFaculty(@PathVariable("id") Long id) {
        return facultyService.getStudentsOfFaculty(id);
    }

    @GetMapping("/facultyOfName")
    public ResponseEntity<Collection<Faculty> >findByNameContainsIgnoreCase(
            @RequestParam(required = false) String name, @RequestParam(required = false) String color) {
        return ResponseEntity.ok(facultyService.findByNameContainsIgnoreCaseOrColorContainsIgnoreCase(name, color));
    }




    @PutMapping
    public Faculty updateFaculty(@RequestBody Faculty faculty) {
        return facultyService.updateFaculty(faculty.getId(), faculty);
    }

    @DeleteMapping("/{id}")
    public void deleteFaculty(@PathVariable("id") Long id) {
         facultyService.deleteFaculty(id);
    }
}
