package com.homework.homework_school.repository;

import com.homework.homework_school.model.Avatar;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AvatarRepositoryPagable extends PagingAndSortingRepository<Avatar, Long> {

}
