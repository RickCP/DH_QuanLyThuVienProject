package com.quanlythuvien.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.quanlythuvien.domain.User;

/**
 * 
 * @author lvhuy08t2@gmail.com
 * 
 */
public interface UserRepository extends JpaRepository<User, Long> {
	User findByUsername(String username);
}
