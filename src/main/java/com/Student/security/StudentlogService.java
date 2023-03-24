package com.Student.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.Student.model.Student;
import com.Student.repository.StudentRepository;

@Service
public class StudentlogService implements UserDetailsService{
    @Autowired
    StudentRepository studentRepository;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        // TODO Auto-generated method stub
        Student student = studentRepository.findById(username).get();
        if(student == null) {
            return null;
        }
        
        return new Studentlog(student);
    }
    
}