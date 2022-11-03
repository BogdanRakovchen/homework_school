package com.homework.homework_school.service;

import com.homework.homework_school.model.Student;
import com.homework.homework_school.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SynhronizedStudentService {

    @Autowired
    private StudentRepository studentRepository;

    public void firstStudents() {

        studentRepository.findAll().stream()
                .limit(2)
                .forEach(e -> System.out.println(e.getName()));
    }

    Thread thread2 = new Thread() {
        public void run() {
            List<Student> students = studentRepository.findAll();
            int i = 0;

                for (; i < students.size(); i++) {
                    if (i > 1 && i < 4) {
                        int finalI = i;
                        synchronized (students.get(finalI).getName()) {

                        System.out.println(students.get(finalI).getName());


                    }
                }
            }
        }
    };

    Thread thread3 = new Thread() {
        public void run() {
            List<Student> students = studentRepository.findAll();
            int i = 0;

                for (; i < students.size(); i++) {
                    if (i >= 4 && i <= 5) {
                        int finalI1 = i;
                        synchronized (students.get(finalI1).getName()) {

                        System.out.println(students.get(finalI1).getName());

                    }
                }
            }
        }
    };


    public void output() {
        thread2.start();
        thread3.start();
    }

}
