package com.rick.spring.thymeleaf.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.rick.spring.thymeleaf.domain.User;

/**
 * 
 * @author lvhuy08t2@gmail.com
 * 
 */
public interface UserRepository extends JpaRepository<User, Long> {
	User findByUsername(String username);
}
