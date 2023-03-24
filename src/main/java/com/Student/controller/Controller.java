package com.Student.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Student.jwt.JwtUtils;
import com.Student.model.Student;
import com.Student.service.StudentService;

@CrossOrigin(origins ="http://localhost:3000/" )
@RestController
@RequestMapping("/api")
public class Controller {
	private StudentService studentService;

	@Autowired
	AuthenticationManager authmanage;

	@Autowired
	JwtUtils jwtUtils;

	public Controller(StudentService studentService) {
		super();
		this.studentService = studentService;
	}
//	@PostMapping("/student")
//	public ResponseEntity<Student> addStudent(@RequestBody Student student){
//				String pass = student.getStudent_password();
//				student.setStudent_password(new BCryptPasswordEncoder().encode(pass));
//		return new ResponseEntity<Student>(studentService.addStudent(student), HttpStatus.CREATED);
//
//	}

	@PostMapping("/authenticate")
	public String authDoctor(@RequestBody Student student){
		try {
			@SuppressWarnings("unused")

			Authentication authtoken=  authmanage.authenticate(
					new UsernamePasswordAuthenticationToken(student.getStudent_email(), student.getStudent_password()));
			String token = jwtUtils.generateToken(student.getStudent_email().toString());
			return token;
//			return "Loggedin successfully";

		} catch (Exception e) {
			// TODO: handle exception
			return "Login Failed";
		}
	}
}
