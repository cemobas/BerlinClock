package com.ubs.opsit.interviews.exception;

public class IllegalTimeInputException extends IllegalArgumentException {

	public static final String DESC_ILL_HOUR = "Incorrect hour format";
	public static final String DESC_ILL_MINUTE = "Incorrect minute format.";
	public static final String DESC_ILL_SECOND = "Incorrect second format.";
	public static final String DESC_ILL_FORMAT = "Input doesn't fit HH:MM:SS format.";
	private String value;
	
	public IllegalTimeInputException(final String description, final String value){
		super(description);
		this.setValue(value);
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}
}
