package com.example.vaccinationcenter.validators.antn;

import
com.example.vaccinationcenter.validators.impl.VaccinationCenterDtoValidator;
import java.lang.annotation.*;

import javax.validation.Constraint;
import javax.validation.Payload;
@Documented
@Constraint(validatedBy = {VaccinationCenterDtoValidator.class})
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
public @interface VaccinationCenterValidator {
String message() default "Invalid Vaccination center data";
Class<?>[] groups() default {};
Class<? extends Payload>[] payload() default {};
}