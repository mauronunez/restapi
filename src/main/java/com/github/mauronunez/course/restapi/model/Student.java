package com.github.mauronunez.course.restapi.model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

import lombok.Data;

@Data
@Entity
public class Student {

	@Id
	@NotNull
	private String rut;
	@NotNull
	private String name;
	@NotNull
	private String lastName;
	@Min(18)
	private Integer age;
	@ManyToOne(optional = false, cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	private Course course;

}
