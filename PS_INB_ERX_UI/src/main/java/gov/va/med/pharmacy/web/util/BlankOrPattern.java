package gov.va.med.pharmacy.web.util;

import java.lang.annotation.Documented;
import static  java.lang.annotation.ElementType.FIELD;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;
import javax.validation.constraints.Pattern.Flag;

import static java.lang.annotation.RetentionPolicy.RUNTIME;


@Target( {FIELD})
@Retention(RUNTIME)
@Documented
@Constraint(validatedBy = BlankOrPatternValidator.class)
public @interface BlankOrPattern {
    String regexp();
    Flag[] flags() default {};
    String message() default "{javax.validation.constraints.Pattern.message}";
    Class<?>[] groups() default { };
    Class<? extends Payload>[] payload() default {};
}
