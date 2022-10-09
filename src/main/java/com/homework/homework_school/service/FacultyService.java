package com.homework.homework_school.service;

import com.homework.homework_school.model.Faculty;
import com.homework.homework_school.model.Student;
import com.homework.homework_school.repository.FacultyRepository;
import com.homework.homework_school.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;


import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Service
public class FacultyService {


    @Autowired
    private final FacultyRepository facultyRepository;



    public FacultyService(FacultyRepository facultyRepository) {


        this.facultyRepository = facultyRepository;
    }



    public Faculty createFaculty(Faculty faculty) {
      return facultyRepository.save(faculty);
    }

    public Faculty getFaculty(Long id) {
        return facultyRepository.findById(id).get();

    }

    public Collection<Student> getStudentsOfFaculty(Long id) {
        Collection<Student> students = Optional.of(facultyRepository.findById(id).get().getStudents())
                                        .orElseGet(() -> facultyRepository.findById(id).get().getStudents());
        return students;
    }

    public Collection<Faculty> findByNameContainsIgnoreCaseOrColorContainsIgnoreCase(String name, String color) {
        return facultyRepository.findByNameContainsIgnoreCaseOrColorContainsIgnoreCase(name, color);
    }


    public Faculty getAllFaculty(String color) {
        List<Faculty> faculty = facultyRepository.findAll();
        for (Faculty faculty1 : faculty) {
            if(faculty1.getColor() == color) {
                return facultyRepository.save(faculty1);
            }
        }
        return (Faculty) faculty;
    }

    public Faculty updateFaculty(Long id, Faculty faculty) {
        Faculty newFaculty = facultyRepository.findById(id).get();
        return facultyRepository.save(newFaculty);
    }

    public void deleteFaculty(Long id) {
         facultyRepository.deleteById(id);

    }
}
