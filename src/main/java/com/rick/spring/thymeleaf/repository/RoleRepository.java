package com.rick.spring.thymeleaf.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.rick.spring.thymeleaf.domain.Role;

/**
 *
 * @author lvhuy08t2@gmail.com
 *
 */
public interface RoleRepository extends JpaRepository<Role,Long> {

}
