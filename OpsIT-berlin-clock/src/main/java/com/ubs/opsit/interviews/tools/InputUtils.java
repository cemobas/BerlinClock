package com.ubs.opsit.interviews.tools;

import com.ubs.opsit.interviews.exception.IllegalTimeInputException;


public class InputUtils {

	private static final String SEPARATOR = ":";

	/**
	 * Returns array form of the time input
	 * @param time
	 * @return
	 * @throws IllegalTimeInputException
	 */
	public static String[] getHhMmSs(final String time) throws IllegalTimeInputException {
		final String[] timeArr = time.split(SEPARATOR);
		if(timeArr.length != 3) {
			throw new IllegalTimeInputException(IllegalTimeInputException.DESC_ILL_FORMAT, time);
		}
		if(!hasOnlyTwoDigits(timeArr[0]) || !isHourWithinBoundary(timeArr[0])) {
			throw new IllegalTimeInputException(IllegalTimeInputException.DESC_ILL_HOUR, timeArr[0]);
		}
		if(!hasOnlyTwoDigits(timeArr[1]) || !isMinuteWithinBoundary(timeArr[1])) {
			throw new IllegalTimeInputException(IllegalTimeInputException.DESC_ILL_MINUTE, timeArr[1]);
		}
		if(!hasOnlyTwoDigits(timeArr[2]) || !isSecondWithinBoundary(timeArr[2])) {
			throw new IllegalTimeInputException(IllegalTimeInputException.DESC_ILL_SECOND, timeArr[2]);
		}
		return timeArr;
	}

	/**
	 * Checks if the value has two digits: no more, no less
	 * @param digits
	 * @return
	 */
	private static boolean hasOnlyTwoDigits(final String digits) {
		return digits.matches("\\d{2}");
	}

	/**
	 * Checks if the hour value is within the boundary of 24 hours
	 * @param string
	 * @return
	 */
	private static boolean isHourWithinBoundary(final String string) {
		return Integer.valueOf(string) >= 0 && Integer.valueOf(string) <= 24; 
	}

	/**
	 * Checks if the minute value is within the boundary of 60 minutes
	 * @param string
	 * @return
	 */
	private static boolean isMinuteWithinBoundary(final String string) {
		return Integer.valueOf(string) >= 0 && Integer.valueOf(string) < 60; 
	}

	/**
	 * Checks if the second value is within the boundary of 60 seconds
	 * @param string
	 * @return
	 */
	private static boolean isSecondWithinBoundary(final String string) {
		return Integer.valueOf(string) >= 0 && Integer.valueOf(string) < 60; 
	}

}
