package com.in.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.in.entity.User;

public interface UserJpaRepo extends JpaRepository<User, Integer>{

}
