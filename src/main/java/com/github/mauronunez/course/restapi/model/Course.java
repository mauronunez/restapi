package com.github.mauronunez.course.restapi.model;

import lombok.Data;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Data
@Entity
public class Course {
	@Id
	@Size(max=4)
	@NotNull
	private String code;
	@NotNull
	private String name;

}
