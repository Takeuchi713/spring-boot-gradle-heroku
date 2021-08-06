package com.takeuchi.herokudemogradle.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.takeuchi.herokudemogradle.model.MyUser;

public interface MyUserRepository extends JpaRepository<MyUser, String>{

}
