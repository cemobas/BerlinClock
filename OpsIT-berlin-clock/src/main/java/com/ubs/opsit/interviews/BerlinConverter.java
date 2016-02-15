package com.ubs.opsit.interviews;

import com.ubs.opsit.interviews.exception.IllegalTimeInputException;

public class BerlinConverter implements TimeConverter {

	@Override
	public String convertTime(String aTime) {
		// TODO Auto-generated method stub
		return null;
	}

	public String getBerlinSecond(String time) {
		StringBuffer berlinSecond = new StringBuffer();
		try {
			final String timeSecond = InputUtils.getHhMmSs(time)[0];
			if (Integer.valueOf(timeSecond) % 2 == 0) {
				berlinSecond.append("Y");
			} else {
				berlinSecond.append("O");
			}
		} catch (IllegalTimeInputException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return berlinSecond.toString();
	}

	public String getBerlinHour(String time) {
		StringBuffer berlinHour = new StringBuffer();
		try {
			final String timeHourStr = InputUtils.getHhMmSs(time)[1];
			final int timeHour = Integer.valueOf(timeHourStr);
			final int capacity1 = 4;
			final int capacity2 = 4;
			for(int i=0; i<timeHour/5; ++i) {
				berlinHour.append("R");
			}
			for(int i=0; i<capacity1-timeHour/5; ++i) {
				berlinHour.append("O");
			}
			berlinHour.append(System.getProperty("line.separator"));
			for(int i=0; i<timeHour%5; ++i) {
				berlinHour.append("R");
			}
			for(int i=0; i<capacity2-timeHour%5; ++i) {
				berlinHour.append("O");
			}
		} catch (IllegalTimeInputException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return berlinHour.toString();
	}

	public String getBerlinMinute(String time) {
		StringBuffer berlinMinute = new StringBuffer();
		try {
			final String timeMinuteStr = InputUtils.getHhMmSs(time)[2];
			final int timeMinute = Integer.valueOf(timeMinuteStr);
			final int capacity1 = 11;
			final int capacity2 = 4;
			for(int i=0; i<timeMinute/5; ++i) {
				for(int j=1; j<=timeMinute/5; ++j){
					if(j%3==0) {
						berlinMinute.append("R");
					} else {
						berlinMinute.append("Y");
					}
				}
			}
			for(int i=0; i<capacity1-timeMinute/5; ++i) {
				berlinMinute.append("O");
			}
			berlinMinute.append(System.getProperty("line.separator"));
			for(int i=0; i<timeMinute%5; ++i) {
				berlinMinute.append("Y");
			}
			for(int i=0; i<capacity2-timeMinute%5; ++i) {
				berlinMinute.append("O");
			}
		} catch (IllegalTimeInputException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return berlinMinute.toString();
	}

}
