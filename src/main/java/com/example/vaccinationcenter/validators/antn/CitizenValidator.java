package com.example.vaccinationcenter.validators.antn;


import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

import com.example.vaccinationcenter.validators.impl.CitizenDtoValidator;
@Documented
@Constraint(validatedBy = {CitizenDtoValidator.class})
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
public @interface CitizenValidator {
String message() default "Invalid Vaccination center data";
Class<?>[] groups() default {};
Class<? extends Payload>[] payload() default {};
}