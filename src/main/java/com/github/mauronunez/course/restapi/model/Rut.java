package com.github.mauronunez.course.restapi.model;

import java.io.Serializable;

import javax.persistence.Embeddable;

import lombok.Data;

@Data
@Embeddable
public class Rut implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 8906104444477930676L;
	private Integer rut;
	private String dv;
	


}
