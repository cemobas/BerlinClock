package com.ubs.opsit.interviews.exception;

import com.ubs.opsit.interviews.tools.ExcType;

/**
 * Exception class to cover exceptions on Berlin Clock.
 * @author CEMOBAS
 *
 */
public class BerlinClockException extends Exception {

	private ExcType excType;
	
	/**
	 * Constructor
	 * @param message
	 * @param exceptionType
	 */
	public BerlinClockException(final String message, final ExcType excType) {
		super(message);
		this.excType = excType;
	}

	/**
	 * Returns exc type
	 * @return
	 */
	public ExcType getExcType() {
		return excType;
	}

	/**
	 * Sets exc type
	 * @param excType
	 */
	public void setExcType(ExcType excType) {
		this.excType = excType;
	}
}
