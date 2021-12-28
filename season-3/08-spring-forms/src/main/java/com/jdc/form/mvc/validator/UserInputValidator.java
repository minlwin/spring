package com.jdc.form.mvc.validator;

import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.jdc.form.root.dto.UserInput;

@Component
public class UserInputValidator implements Validator{

	@Override
	public boolean supports(Class<?> clazz) {
		return UserInput.class.isAssignableFrom(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		
		if(target instanceof UserInput input) {
			
			if(!StringUtils.hasLength(input.getPhone()) && 
					!StringUtils.hasLength(input.getEmail())) {
				errors.rejectValue("phone", "empty", "Enter Phone or Email.");
				errors.rejectValue("email", "empty", "Enter Phone or Email.");
			}
		}
		
	}

	
}
