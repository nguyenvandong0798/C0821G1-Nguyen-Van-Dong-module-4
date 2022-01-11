package com.codegym.casestudy.common.idcard;


import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = IdCardValidator.class)
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
public @interface IdCardConstraint {
String message() default "ID card is 9 numbers";
Class<?> [] groups() default {};
Class<? extends Payload> [] payload() default {};

}
