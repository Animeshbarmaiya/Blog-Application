package com.example.demo.Entity;

import java.sql.Date;
import java.util.List;

import org.hibernate.annotations.Cascade;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Data;
import jakarta.persistence.GenerationType;
import lombok.NoArgsConstructor;
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@Column(nullable = false)
	private String name;
	@Column(unique = true,nullable = false)
	private String email;
	@Column(unique = true,nullable=false)
	private Long phoneNO;
	@Column(nullable = false)
	private String password;
	private char gender;
	private Date dob;
	@OneToMany(mappedBy = "user")
	private List<Post> post;
	@OneToMany(mappedBy = "user")
	private List<Comment> comments; 
}
