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

    @Autowired
    private final StudentRepository studentRepository;

    public FacultyService(FacultyRepository facultyRepository, StudentRepository studentRepository) {


        this.facultyRepository = facultyRepository;
        this.studentRepository = studentRepository;

    }



    public Faculty createFaculty(Faculty faculty) {
      return facultyRepository.save(faculty);
    }

    public Faculty getFaculty(Long id) {
        return facultyRepository.findById(id).get();

    }

    public Collection<Student> getStudentsOfFaculty(Long id) {
        Collection<Student> students = null;
        Long idx = facultyRepository.findById(id).get().getId();
        if(idx == id) {
           students = facultyRepository.findById(id).get().getStudents();
        };
        return students;
    }

    public Faculty findByNameContainsIgnoreCase(String nameOrColor) {
        return facultyRepository.findByNameContainsIgnoreCase(nameOrColor);
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
