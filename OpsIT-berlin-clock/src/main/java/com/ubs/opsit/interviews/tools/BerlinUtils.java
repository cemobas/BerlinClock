package com.ubs.opsit.interviews.tools;

import com.ubs.opsit.interviews.exception.IllegalTimeInputException;

/**
 * Utility class for processing operations.
 * @author CEMOBAS
 *
 */
public class BerlinUtils {

	private static int CAPACITY_ROW235 = 4;
	private static int CAPACITY_ROW4 = 11;
	private static char LAMP_YELLOW = 'Y';
	private static char LAMP_RED = 'R';
	private static char LAMP_OFF = 'O';

	/**
	 * Returns Berlin-Second value out of given time
	 * @param time
	 * @return
	 */
	public static String getBerlinSecond(String time) {
		StringBuffer berlinSecond = new StringBuffer();
		try {
			processRow1(berlinSecond,
					Integer.valueOf(InputUtils.getHhMmSs(time)[0]));
		} catch (IllegalTimeInputException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return berlinSecond.toString();
	}

	/**
	 * Returns Berlin-Hour value out of given time
	 * @param time
	 * @return
	 */
	public static String getBerlinHour(String time) {
		StringBuffer berlinHour = new StringBuffer();
		try {
			final int timeHour = Integer.valueOf(InputUtils.getHhMmSs(time)[1]);
			processRow2(berlinHour, timeHour);
			berlinHour.append(System.getProperty("line.separator"));
			processRow3(berlinHour, timeHour);
		} catch (IllegalTimeInputException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return berlinHour.toString();
	}

	/**
	 * Returns Berlin-Minute value out of given time
	 * @param time
	 * @return
	 */
	public static String getBerlinMinute(String time) {
		StringBuffer berlinMinute = new StringBuffer();
		try {
			final int timeMinute = Integer.valueOf(InputUtils.getHhMmSs(time)[2]);
			processRow4(berlinMinute, timeMinute);
			berlinMinute.append(System.getProperty("line.separator"));
			processRow5(berlinMinute, timeMinute);
		} catch (IllegalTimeInputException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return berlinMinute.toString();
	}

	/**
	 * Processes 1st row on Berlin Clock to display Second.
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
	 * @param sb
	 * @param value
	 */
	private static void processRow2(final StringBuffer sb, final int value) {
		turnOnReds(sb, value / 5);
		turnOffLamps(sb, CAPACITY_ROW235 - value / 5);
	}


	/**
	 * Processes 3rd row on Berlin Clock to display Hour.
	 * @param sb
	 * @param value
	 */
	private static void processRow3(final StringBuffer sb, final int value) {
		turnOnReds(sb, value % 5);
		turnOffLamps(sb, CAPACITY_ROW235 - value % 5);
	}


	/**
	 * Processes 4th row on Berlin Clock to display Minute.
	 * @param sb
	 * @param value
	 */
	private static void processRow4(final StringBuffer sb, final int value) {
		for (int i = 0; i < value / 5; ++i) {
			for (int j = 1; j <= value / 5; ++j) {
				if (j % 3 == 0) {
					sb.append(LAMP_RED);
				} else {
					sb.append(LAMP_YELLOW);
				}
			}
		}
		turnOffLamps(sb, CAPACITY_ROW4 - value / 5);
	}
	
	/**
	 * Processes 5th row on Berlin Clock to display Minute.
	 * @param sb
	 * @param value
	 */
	private static void processRow5(final StringBuffer sb, final int value) {
		turnOnYellows(sb, value % 5);
		turnOffLamps(sb, CAPACITY_ROW235 - value % 5);
	}
	
	/**
	 * Turns off lamps in given set within given range
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
	 * @param sb
	 * @param amount
	 */
	private static void turnOnYellows(final StringBuffer sb, final int amount) {
		for (int i = 0; i < amount; ++i) {
			sb.append(LAMP_YELLOW);
		}
	}
}
