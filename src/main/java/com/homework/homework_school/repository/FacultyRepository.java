package com.homework.homework_school.repository;

import com.homework.homework_school.model.Faculty;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface FacultyRepository extends JpaRepository<Faculty, Long> {
}
