package com.codegym.casestudy.common.email;


import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = EmailValidator.class)
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
public @interface EmailConstraint {
String message() default "Email is wrong format";
Class<?> [] groups() default {};
Class<? extends Payload> [] payload() default {};

}
