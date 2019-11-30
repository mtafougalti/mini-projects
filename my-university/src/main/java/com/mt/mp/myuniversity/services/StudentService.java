package com.mt.mp.myuniversity.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mt.mp.myuniversity.entities.Student;
import com.mt.mp.myuniversity.repositories.StudentRepository;

@RestController
@RequestMapping("/student")
public class StudentService {
	
	@Autowired
	private StudentRepository studentRepository;
	
	@PostMapping("/add")
	@Secured({"ROLE_ADMIN"})
	public Student add(@RequestBody Student student) {
		return studentRepository.save(student);
	}
	
	@GetMapping("/page")
	@Secured({"ROLE_ADMIN", "ROLE_USER"})
	public Page<Student> list(int page, int size){
		return studentRepository.findAll(PageRequest.of(page, size));
	}
	
	@GetMapping("/list")
	@Secured({"ROLE_ADMIN", "ROLE_USER"})
	public List<Student> list(){
		return studentRepository.findAll();
	}

}
