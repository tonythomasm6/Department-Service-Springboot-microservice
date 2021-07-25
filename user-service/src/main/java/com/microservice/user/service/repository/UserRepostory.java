package com.microservice.user.service.repository;

import com.microservice.user.service.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepostory extends JpaRepository<User, Long> {
    User findByUserId(Long userId);
}
