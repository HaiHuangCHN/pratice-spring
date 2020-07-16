package com.hai.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hai.entity.User;

public interface UserRepository extends JpaRepository<User, Long> {

    User findById(long id);

    void deleteById(long id);
}