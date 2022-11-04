package com.homework.homework_school;

import com.homework.homework_school.controller.StudentController;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import static org.assertj.core.api.Assertions.assertThat;



@SpringBootTest
class HomeworkSchoolApplicationTests {

@Autowired
private StudentController studentController;


    @Test
    void contextLoads() {
        assertThat(studentController).isNotNull();
    }


}
