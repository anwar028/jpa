package com.in.repo;

import org.springframework.data.repository.CrudRepository;

import com.in.entity.User;

public interface UserRepo extends CrudRepository<User, Integer> {
	
	

}
