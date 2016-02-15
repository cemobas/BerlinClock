package com.ubs.opsit.interviews;

import org.apache.log4j.Logger;

import com.ubs.opsit.interviews.exception.IllegalTimeInputException;
import com.ubs.opsit.interviews.tools.BerlinUtils;
import com.ubs.opsit.interviews.tools.InputUtils;

/**
 * Main class to run the operation.
 * @author CEMOBAS
 *
 */
public class BerlinConverter implements TimeConverter {

	private final Logger LOGGER = Logger.getLogger(BerlinConverter.class);

	@Override
	public String convertTime(String aTime) {
		final StringBuffer sb = new StringBuffer();
		try {
			String[] aTimeArr = InputUtils.getHhMmSs(aTime);
			sb.append(BerlinUtils.getBerlinSecond(Integer.valueOf(aTimeArr[2])));
			sb.append("\r\n");
			sb.append(BerlinUtils.getBerlinHour(Integer.valueOf(aTimeArr[0])));
			sb.append("\r\n");
			sb.append(BerlinUtils.getBerlinMinute(Integer.valueOf(aTimeArr[1])));
		} catch (IllegalTimeInputException e) {
			LOGGER.error(e.getMessage());
		}
		return sb.toString();
	}
}
