package com.homework.homework_school.service;

import com.homework.homework_school.model.Faculty;
import com.homework.homework_school.model.Student;
import com.homework.homework_school.repository.FacultyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;


import java.util.HashMap;
import java.util.List;
import java.util.Map;
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
