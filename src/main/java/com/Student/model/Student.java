package com.Student.model;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name = "student")
public class Student {
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long student_id;

	//	@Column(name = "student_firstname")
	//	private String student_firstname;
	//	
	//	@Column(name = "student_lastname")
	//	private String student_lastname;

	@Id
	@Column(name = "student_email")
	private String student_email;

	@Column(name = "student_password")
	private String student_password;

	//	@Column(name = "dob")
	//	private String dob;
	//	
	//	@Column(name = "gender")
	//	private String gender;
	//	
	//	@Column(name = "student_class")
	//	private int student_class;
	//	
	//	@Column(name = "fathername")
	//	private String fathername;
	//	
	//	@Column(name = "mothername")
	//	private String mothername;	
	//
	//	@Column(name = "fees")
	//	private Boolean fees;

	public Student() {
		super();
	}

	public Student(long student_id, String student_email, String student_password) {
		super();
		this.student_id = student_id;
		this.student_email = student_email;
		this.student_password = student_password;
	}

	public long getStudent_id() {
		return student_id;
	}

	public void setStudent_id(long student_id) {
		this.student_id = student_id;
	}

	public String getStudent_email() {
		return student_email;
	}

	public void setStudent_email(String student_email) {
		this.student_email = student_email;
	}

	public String getStudent_password() {
		return student_password;
	}

	public void setStudent_password(String student_password) {
		this.student_password = student_password;
	}

	@Override
	public int hashCode() {
		return Objects.hash(student_email, student_id, student_password);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Student other = (Student) obj;
		return Objects.equals(student_email, other.student_email) && student_id == other.student_id
				&& Objects.equals(student_password, other.student_password);
	}

}