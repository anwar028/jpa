package com.in;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import com.in.entity.User;
import com.in.repo.UserRepo;

@SpringBootApplication
public class JpaFirstAppApplication {

	public static void main(String[] args) {
		ConfigurableApplicationContext context = SpringApplication.run(JpaFirstAppApplication.class, args);

		UserRepo ur = context.getBean(UserRepo.class);

		System.out.println(ur.getClass().getName());

		User u = new User(101, "Anwar", "anwar123@gmail.com", 29, "HYD");
		User u1 = new User(102, "mahesh", "mahesh123@gmail.com", 26, "TS");
		User u2 = new User(103, "shiva", "shiva123@gmail.com", 30, "AP");
		User u3 = new User(104, "saiteja", "sai123@gmail.com", 28, "TG");
		User u4 = new User(105, "anil", "anil123@gmail.com", 32, "PDPL");

		List<User> list = Arrays.asList(u, u1, u2, u3, u4);

		ur.saveAll(list);

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

		long count = ur.count();
		System.out.println("Total avalable records in the table: " + count);

		boolean existByid = ur.existsById(102);
		System.out.println("Record status: " + existByid);

		boolean existByid1 = ur.existsById(106);
		System.out.println("Record status: "+existByid1);
		
		
		ur.deleteById(102);

	}

}
