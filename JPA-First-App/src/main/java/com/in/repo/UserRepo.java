package com.in.repo;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.in.entity.User;

public interface UserRepo extends CrudRepository<User, Integer> {

	List<User> findByLocation(String location);

	List<User> findByAge(Integer age);

	public List<User> findByAgeGreaterThanEqual(Integer age);

	public List<User> findByAgeGreaterThanAndLocation(Integer age, String location);

	public List<User> findByLocationIn(List<String> countries);

	@Query(value = "from User")
	// @Query("SELECT u FROM User u")
	public List<User> getAllUsersHql();

	//@Query(value = "From User where location=:area")
	@Query(value="select*from user_master where user_name =:area", nativeQuery=true)
	public List<User> getAllUsersBasedOnLocation(String area);

}
