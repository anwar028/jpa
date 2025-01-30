package com.in;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.data.domain.Sort;

import com.in.entity.User;
import com.in.repo.UserJpaRepo;
import com.in.repo.UserRepo;

@SpringBootApplication
public class JpaFirstAppApplication {

	public static void main(String[] args) {
		ConfigurableApplicationContext context1 = SpringApplication.run(JpaFirstAppApplication.class, args);

		// UserRepo ur = context.getBean(UserRepo.class);

		// System.out.println(ur.getClass().getName());

		UserJpaRepo urj = context1.getBean(UserJpaRepo.class);

		System.out.println(urj.getClass().getName());

		User u = new User(101, "Anwar", "anwar123@gmail.com", 29, "HYD");
		User u1 = new User(102, "mahesh", "mahesh123@gmail.com", 26, "TS");
		User u2 = new User(103, "shiva", "shiva123@gmail.com", 30, "AP");
		User u3 = new User(104, "saiteja", "sai123@gmail.com", 28, "TG");
		User u4 = new User(105, "anil", "anil123@gmail.com", 32, "PDPL");

		List<User> list = Arrays.asList(u, u1, u2, u3, u4);

		urj.saveAll(list);
		// ur.saveAll(list);

		/*
		 * Optional<User> findById = ur.findById(103);
		 * 
		 * if (findById.isPresent()) { User user = findById.get();
		 * System.out.println(user);
		 * 
		 * 
		 * }
		 */

		/*
		 * Iterable<User>findAllById =
		 * ur.findAllById(Arrays.asList(101,102,103,104,105));
		 * 
		 * findAllById.forEach(System.out::println);
		 * 
		 */

		/*
		 * Iterable<User> findAll = ur.findAll();
		 * 
		 * findAll.forEach(System.out::println);
		 */

		/*
		 * long count = ur.count();
		 * System.out.println("Total avalable records in the table: " + count);
		 * 
		 * boolean existByid = ur.existsById(102); System.out.println("Record status: "
		 * + existByid);
		 * 
		 * boolean existByid1 = ur.existsById(106);
		 * System.out.println("Record status: "+existByid1);
		 * 
		 * 
		 * ur.deleteById(102);
		 */

		/*
		 * List<User> findByLocation = ur.findByLocation("AP");
		 * 
		 * findByLocation.forEach(System.out::println);
		 */

		/*
		 * List<User> findByAge = ur.findByAge(29);
		 * 
		 * findByAge.forEach(System.out::println);
		 */

		/*
		 * List<User> findByAgeGreaterThanEqual = ur.findByAgeGreaterThanEqual(30);
		 * 
		 * findByAgeGreaterThanEqual.forEach(System.out::println);
		 */

		/*
		 * List<User> ageAndLocation = ur.findByAgeGreaterThanAndLocation(20, "HYD");
		 * 
		 * ageAndLocation.forEach(System.out::println);
		 */

		/*
		 * List<User> findByLocationIn =
		 * ur.findByLocationIn(Arrays.asList("USA","AP","TS","HYD"));
		 * 
		 * findByLocationIn.forEach(System.out::println);
		 * 
		 * System.out.println("------------------------------------");
		 */

		// List<User> allUsershql = ur.getAllUsersHql();

		// allUsershql.forEach(System.out::println);

		// allUsershql.forEach(e -> System.out.println(e));

		/*
		 * List<User> allUsersBasedOnLocation = ur.getAllUsersBasedOnLocation("Anwar");
		 * 
		 * // allUsersBasedOnLocation.forEach(area->
		 * System.out.println("nativeSQL: "+area));
		 * 
		 * allUsersBasedOnLocation.forEach(area-> System.out.println("SQL: "+area));
		 */

		List<User> findAll = urj.findAll(Sort.by("userId").descending());

		findAll.forEach(System.out::println);

		System.out.println("------------------------------------");

		List<User> findAll2 = urj.findAll(Sort.by("name"));

		findAll2.forEach(e -> System.out.println("SortbyNames: " + e));

		List<User> sortByNameAndId = urj.findAll(Sort.by(Sort.Order.asc("name"), Sort.Order.desc("userId")));
		
		sortByNameAndId.forEach(e-> System.out.println("sortByNameAndId: "+e));

	}

}
