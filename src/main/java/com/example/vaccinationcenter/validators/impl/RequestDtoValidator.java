package com.example.vaccinationcenter.validators.impl;

import javax.validation.ConstraintValidatorContext;

public interface RequestDtoValidator<T> {
public boolean validate(T requestData, ConstraintValidatorContext context);
}