package com.in.entity;

import jakarta.persistence.Entity;
import lombok.Data;

@Entity
@Data
public class User {

	private Integer userId;
	private String name;
	private String email;
	private Integer age;
	private String location;

}
