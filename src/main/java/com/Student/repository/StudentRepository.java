package com.Student.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.Student.model.Student;

public interface StudentRepository extends JpaRepository<Student, String> {

}
