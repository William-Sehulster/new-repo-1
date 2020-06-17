package gov.va.med.pharmacy.web.util;

import static  java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;


@Target( {FIELD})
@Retention(RUNTIME)
@Documented
@Constraint(validatedBy = BlankOrLengthValidator.class)
public @interface BlankOrLength {
	int min() default 0;

	int max() default Integer.MAX_VALUE;	
    
    String message() default "{org.hibernate.validator.constraints.Length.message}";
   
    Class<?>[] groups() default { };
    
    Class<? extends Payload>[] payload() default {};
}
