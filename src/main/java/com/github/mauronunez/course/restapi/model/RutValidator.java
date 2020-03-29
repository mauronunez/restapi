package com.github.mauronunez.course.restapi.model;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class RutValidator implements ConstraintValidator<RutConstraint, String> {

	private static String SEPARATOR="-";
	
	@Override
	public boolean isValid(String input, ConstraintValidatorContext context) {

		String[] parts = input.split(SEPARATOR);
		if (parts.length == 2) {
			return validateRut(input);
		} else {
			return false;
		}
	}
	
	public static boolean validateRut(String rut) {

		boolean valid = false;
		try {
		rut =  rut.toUpperCase();
		rut = rut.replace(".", "");
		rut = rut.replace("-", "");
		int rutAux = Integer.parseInt(rut.substring(0, rut.length() - 1));
		char dv = rut.charAt(rut.length() - 1);

		int m = 0, s = 1;
		for (; rutAux != 0; rutAux /= 10) {
		s = (s + rutAux % 10 * (9 - m++ % 6)) % 11;
		}
		if (dv == (char) (s != 0 ? s + 47 : 75)) {
			valid = true;
		}

		} catch (java.lang.NumberFormatException e) {
		} catch (Exception e) {
		}
		return valid;
		}
	
	

}
