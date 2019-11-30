package com.mt.mp.myuniversity.services;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mt.mp.myuniversity.entities.Role;
import com.mt.mp.myuniversity.entities.User;
import com.mt.mp.myuniversity.repositories.RoleRepository;
import com.mt.mp.myuniversity.repositories.UserRepository;

@RestController
@RequestMapping("/user")
public class UserService {
	
	private static final String SPRING_SECURITY_CONTEXT = "SPRING_SECURITY_CONTEXT";
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private RoleRepository roleRepository;
	
	@GetMapping("/logged")
	public Map<String, Object> getLoggedUser(HttpSession httpSession){
		SecurityContext securityContext = (SecurityContext) httpSession.getAttribute(SPRING_SECURITY_CONTEXT);
		String userName = securityContext.getAuthentication().getName();
		List<String> roles = new ArrayList<>();
		securityContext.getAuthentication().getAuthorities().forEach(g -> {
			roles.add(g.getAuthority());
		});
		Map<String, Object> map = new HashMap<>();
		map.put("username", userName);
		map.put("roles", roles);
		return map;
	}
	
	@PostMapping("/addUser")
	public User addUser(@RequestBody User user) {
		return userRepository.save(user);
	}
	
	@PostMapping("/addRole")
	public Role addRole(@RequestBody Role role) {
		return roleRepository.save(role);
	}
	
	@PutMapping("/assignRoleToUser")
	public Role assignRoleToUser(@RequestBody Role role) {
		return roleRepository.save(role);
	}
	
	@GetMapping("/users")
	public List<User> users(){
		return userRepository.findAll();
	}
	
	@GetMapping("/roles")
	public List<Role> roles(){
		return roleRepository.findAll();
	}


}
