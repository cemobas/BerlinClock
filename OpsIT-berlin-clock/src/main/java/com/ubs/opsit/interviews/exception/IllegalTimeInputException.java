package com.ubs.opsit.interviews.exception;

import com.ubs.opsit.interviews.tools.ExcType;

/**
 * Input validation failure throws this Exception.
 * @author CEMONUR
 *
 */
public class IllegalTimeInputException extends Exception {
	
	private ExcType excType;
	private String value;
	
	public IllegalTimeInputException(final ExcType excType, final String value){
		this.excType = excType;
		this.value = value;
	}

	public ExcType getExcType() {
		return excType;
	}

	public void setExcType(ExcType excType) {
		this.excType = excType;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}
}
