package gov.va.med.pharmacy.web.util;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;




public class BlankOrLengthValidator  implements ConstraintValidator<BlankOrLength, String>{

	
	private static final org.apache.logging.log4j.Logger LOG = org.apache.logging.log4j.LogManager.getLogger(BlankOrLengthValidator.class);

	private int min;
	private int max;

	@Override
	public void initialize(BlankOrLength parameters) {
		min = parameters.min();
		max = parameters.max();
		validateParameters();
	}

	@Override
	public boolean isValid(String value, ConstraintValidatorContext constraintValidatorContext) {
		if ( value == null  || value.length() == 0) {
			return true;
		}
		
		int length = value.length();
		
		return length >= min && length <= max;
	}

	private void validateParameters() {
		if ( min < 0 ) {
			 throw new IllegalArgumentException("Invalid value for min.");
		}
		if ( max < 0 ) {
			 throw new IllegalArgumentException("Invalid value for max.");
		}
		if ( max < min ) {
			throw new IllegalArgumentException("max can't be less than min.");
		}
	}

	
	
}
