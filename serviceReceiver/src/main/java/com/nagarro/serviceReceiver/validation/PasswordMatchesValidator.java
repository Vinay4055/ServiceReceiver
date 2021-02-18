package com.nagarro.serviceReceiver.validation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import com.nagarro.serviceReceiver.model.ServiceReceiver;
import com.nagarro.serviceReceiver.validation.annotation.PasswordMatches;

public class PasswordMatchesValidator 
implements ConstraintValidator<PasswordMatches, Object> { 
   
  @Override
  public void initialize(PasswordMatches constraintAnnotation) {       
  }
  @Override
  public boolean isValid(Object obj, ConstraintValidatorContext context){   
	  ServiceReceiver serviceReceiver = (ServiceReceiver) obj;
      //return employee.getPassword().equals(employee.getConfirmPassword());    
      return false;
  	}     
}