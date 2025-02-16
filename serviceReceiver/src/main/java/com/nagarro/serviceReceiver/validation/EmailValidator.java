package com.nagarro.serviceReceiver.validation;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import com.nagarro.serviceReceiver.validation.annotation.ValidEmail;



public class EmailValidator 
implements ConstraintValidator<ValidEmail, String> {
   
  private Pattern pattern;
  private Matcher matcher;
 // private static final String EMAIL_PATTERN = "^[_A-Za-z0-9-+]+(.[_A-Za-z0-9-]+)*@[A-Za-z0-9-]+(.[A-Za-z0-9]+)*(.[A-Za-z]{2,})$"; 
  private static final String EMAIL_PATTERN = "^[_A-Za-z0-9-+]+(.[_A-Za-z0-9-]+)*@+nagarro+(.[A-Za-z0-9]+)*(.[A-Za-z]{2,})$"; 
 
  @Override
  public void initialize(ValidEmail constraintAnnotation) {       
  }
  @Override
  public boolean isValid(String email, ConstraintValidatorContext context){   
      return (validateEmail(email));
  } 
  private boolean validateEmail(String email) {
      pattern = Pattern.compile(EMAIL_PATTERN);
      matcher = pattern.matcher(email);
      return matcher.matches();
  }
}
