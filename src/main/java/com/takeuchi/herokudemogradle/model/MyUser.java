package com.takeuchi.herokudemogradle.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name="MyUser")
public class MyUser {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private String id;

	@Column(name = "name", nullable = false, length = 100)
	private String name;

	@Column(name = "email", unique = true, nullable = false, length = 200)
	private String email;

	@Column(name = "age", nullable = true, length = 3)
	private Integer age;

	@Column(name="gender", nullable =true , length = 1)
	private Integer gender;
}
