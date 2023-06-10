package com.jdc.form.mvc.validator;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.springframework.util.StringUtils;

public class PhoneConstraint implements ConstraintValidator<Phone, String>{
	
	private Phone annotation;
	
	@Override
	public void initialize(Phone annotation) {
		this.annotation = annotation;
	}

	@Override
	public boolean isValid(String value, ConstraintValidatorContext context) {
		
		if(StringUtils.hasLength(value)) {
			return value.matches(annotation.pattern());
		}
		
		return true;
	}

}
