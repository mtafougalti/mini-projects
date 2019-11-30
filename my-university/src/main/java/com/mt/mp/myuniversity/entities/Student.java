package com.mt.mp.myuniversity.entities;

import java.io.Serializable;
import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Entity
public class Student implements Serializable {

	private static final long serialVersionUID = -8817670566057732043L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String firstName;
	private String lastName;
	private LocalDate birthDay;

	public Student(String firstName, String lastName, LocalDate birthDay) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.birthDay = birthDay;
	}

}
