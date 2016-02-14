package com.ubs.opsit.interviews;


public class InputUtils implements TimeConverter {

	@Override
	public String convertTime(String aTime) {
		StringBuffer sb = new StringBuffer();
		return sb.toString();
	}

	public static String[] getHhMmSs(String time) throws IllegalArgumentException {
		final String separator = ":";
		final String[] timeArr = time.split(separator);
		if(!hasOnlyTwoDigits(timeArr[0]) || !isHourWithinBoundary(timeArr[0])) {
			throw new IllegalArgumentException("Incorrect hour format: " + timeArr[0]);
		}
		if(!hasOnlyTwoDigits(timeArr[1]) || !isMinuteWithinBoundary(timeArr[1])) {
			throw new IllegalArgumentException("Incorrect minute format: " + timeArr[1]);
		}
		if(!hasOnlyTwoDigits(timeArr[2]) || !isMinuteWithinBoundary(timeArr[2])) {
			throw new IllegalArgumentException("Incorrect second format: " + timeArr[2]);
		}
		return timeArr;
	}

	public static boolean hasOnlyTwoDigits(String digits) {
		return digits.matches("\\d{2}");
	}

	public static boolean isHourWithinBoundary(String string) {
		return Integer.valueOf(string) >= 0 && Integer.valueOf(string) <= 24; 
	}

	public static boolean isMinuteWithinBoundary(String string) {
		return Integer.valueOf(string) >= 0 && Integer.valueOf(string) < 60; 
	}

	public static boolean isSecondWithinBoundary(String string) {
		return Integer.valueOf(string) >= 0 && Integer.valueOf(string) < 60; 
	}

}
