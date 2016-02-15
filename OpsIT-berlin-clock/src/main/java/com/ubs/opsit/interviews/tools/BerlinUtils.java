package com.ubs.opsit.interviews.tools;

/**
 * Utility class for processing operations.
 * 
 * @author CEMOBAS
 *
 */
public class BerlinUtils {

	private static int CAPACITY_ROW235 = 4;
	private static int CAPACITY_ROW4 = 11;
	private static char LAMP_YELLOW = 'Y';
	private static char LAMP_RED = 'R';
	private static char LAMP_OFF = 'O';
	private static String BERLIN_SEPARATOR = "\r\n";

	/**
	 * Returns Berlin-Second value out of given time
	 * 
	 * @param time
	 * @return
	 */
	public static String getBerlinSecond(final int second) {
		StringBuffer berlinSecond = new StringBuffer();
		processRow1(berlinSecond, second);
		return berlinSecond.toString();
	}

	/**
	 * Returns Berlin-Hour value out of given time
	 * 
	 * @param hour
	 * @return
	 */
	public static String getBerlinHour(final int hour) {
		StringBuffer berlinHour = new StringBuffer();
		processRow2(berlinHour, hour);
		berlinHour.append(BERLIN_SEPARATOR);
		processRow3(berlinHour, hour);
		return berlinHour.toString();
	}

	/**
	 * Returns Berlin-Minute value out of given time
	 * 
	 * @param time
	 * @return
	 */
	public static String getBerlinMinute(final int minute) {
		StringBuffer berlinMinute = new StringBuffer();
		processRow4(berlinMinute, minute);
		berlinMinute.append(BERLIN_SEPARATOR);
		processRow5(berlinMinute, minute);
		return berlinMinute.toString();
	}

	/**
	 * Processes 1st row on Berlin Clock to display Second.
	 * 
	 * @param sb
	 * @param value
	 */
	private static void processRow1(final StringBuffer sb, final int value) {
		if (value % 2 == 0) {
			sb.append(LAMP_YELLOW);
		} else {
			sb.append(LAMP_OFF);
		}
	}

	/**
	 * Processes 2nd row on Berlin Clock to display Hour.
	 * 
	 * @param sb
	 * @param value
	 */
	private static void processRow2(final StringBuffer sb, final int value) {
		turnOnReds(sb, value / 5);
		turnOffLamps(sb, CAPACITY_ROW235 - value / 5);
	}

	/**
	 * Processes 3rd row on Berlin Clock to display Hour.
	 * 
	 * @param sb
	 * @param value
	 */
	private static void processRow3(final StringBuffer sb, final int value) {
		turnOnReds(sb, value % 5);
		turnOffLamps(sb, CAPACITY_ROW235 - value % 5);
	}

	/**
	 * Processes 4th row on Berlin Clock to display Minute.
	 * 
	 * @param sb
	 * @param value
	 */
	private static void processRow4(final StringBuffer sb, final int value) {
		for (int i = 1; i <= value / 5; ++i) {
			if (i % 3 == 0) {
				sb.append(LAMP_RED);
			} else {
				sb.append(LAMP_YELLOW);
			}
		}
		turnOffLamps(sb, CAPACITY_ROW4 - value / 5);
	}

	/**
	 * Processes 5th row on Berlin Clock to display Minute.
	 * 
	 * @param sb
	 * @param value
	 */
	private static void processRow5(final StringBuffer sb, final int value) {
		turnOnYellows(sb, value % 5);
		turnOffLamps(sb, CAPACITY_ROW235 - value % 5);
	}

	/**
	 * Turns off lamps in given set within given range
	 * 
	 * @param sb
	 * @param amount
	 */
	private static void turnOffLamps(final StringBuffer sb, final int amount) {
		for (int i = 0; i < amount; ++i) {
			sb.append(LAMP_OFF);
		}
	}

	/**
	 * Turns on lamps to Red in given set within given range
	 * 
	 * @param sb
	 * @param amount
	 */
	private static void turnOnReds(final StringBuffer sb, final int amount) {
		for (int i = 0; i < amount; ++i) {
			sb.append(LAMP_RED);
		}
	}

	/**
	 * Turns on lamps to Yellow in given set within given range
	 * 
	 * @param sb
	 * @param amount
	 */
	private static void turnOnYellows(final StringBuffer sb, final int amount) {
		for (int i = 0; i < amount; ++i) {
			sb.append(LAMP_YELLOW);
		}
	}
}
