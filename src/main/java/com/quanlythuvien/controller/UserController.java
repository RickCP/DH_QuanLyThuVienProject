package com.rick.spring.thymeleaf.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.rick.spring.thymeleaf.domain.Role;
import com.rick.spring.thymeleaf.domain.User;
import com.rick.spring.thymeleaf.reponse.UserDto;
import com.rick.spring.thymeleaf.repository.UserRepository;
import com.rick.spring.thymeleaf.service.UserService;
import com.rick.spring.thymeleaf.util.UserMapper;

/**
 * 
 * @author lvhuy08t2@gmail.com
 * 
 */
@Controller
@RequestMapping("/users")
public class UserController {
	@Autowired
	private UserRepository repository;

	@Autowired
	private UserService service;
	@ModelAttribute("allRoles")
	public List<Integer> getAllRoles() {
		List<Integer> roles = new ArrayList<Integer>();
		roles.add(1);
		roles.add(2);
		return roles;
	}

	@RequestMapping
	public String getUsersPage(ModelMap model) {
		Pageable pageRequest = new PageRequest(0, 10);
		Page<User> users = repository.findAll(pageRequest);
		model.addAttribute("users", UserMapper.map(users));
		model.addAttribute("commanduser", new UserDto());
		model.addAttribute("usertype", "new");
		return "users";
	}

	@RequestMapping(value = "/get", produces = "application/json")
	public @ResponseBody
	UserDto get(@RequestBody UserDto user) {
		return UserMapper.map(repository.findByUsername(user.getUsername()));
	}

	@RequestMapping(value = "/create", produces = "application/json", method = RequestMethod.POST)
	public String create(UserDto dto) {
		if (dto.getId() != null) {
			User existingUser = new User(dto.getUsername(), dto.getFirstName(),
					dto.getLastName(), new Role(dto.getRole()));
			service.update(existingUser);
		} else {
			User newUser = new User(dto.getUsername(), null,
					dto.getFirstName(), dto.getLastName(), new Role(
							dto.getRole()));
			service.create(newUser);
		}

		return "redirect:/users";
	}
	@RequestMapping(value="/edit")
	public String edit(Long id, ModelMap model) {
		Pageable pageRequest = new PageRequest(0, 10);
		Page<User> users = repository.findAll(pageRequest);
		model.addAttribute("users", UserMapper.map(users));
		model.addAttribute("commanduser", UserMapper.map(repository.findOne(id)));
		model.addAttribute("usertype", "update");
		return "users";
	}
	
	@RequestMapping(value="/delete")
	public String delete(Long id) {

		User existingUser = new User();
		existingUser.setId(id);
		service.delete(existingUser);
		return "redirect:/users";
	}

}
