package com.ubs.opsit.interviews;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

public class TestBerlinConverter {

	private BerlinConverter bConverter;
	private String midnightTime;
	private StringBuffer midnightBerlin;
	private StringBuffer second;
	private StringBuffer hour;
	private StringBuffer minute;
	
	@Before
	public void setUp(){
		this.bConverter = new BerlinConverter();
		this.midnightTime = "00:00:00";
		// Second
		this.second = new StringBuffer();
		this.second.append("Y");
		// Hour
		this.hour = new StringBuffer();
		this.hour.append("OOOO");
		this.hour.append(System.getProperty("line.separator"));
		this.hour.append("OOOO");
		// Minute
		this.minute = new StringBuffer();
		this.minute.append("OOOOOOOOOOO");
		this.minute.append(System.getProperty("line.separator"));
		this.minute.append("OOOO");
		// Initializing midnight time
		this.midnightBerlin = new StringBuffer();
		this.midnightBerlin.append(this.second);
		this.midnightBerlin.append(System.getProperty("line.separator"));
		this.midnightBerlin.append(this.hour);
		this.midnightBerlin.append(System.getProperty("line.separator"));
		this.midnightBerlin.append(this.minute);
		
	}

	@Test
	public void testGetBerlinSecond(){
		this.bConverter = new BerlinConverter();
		final String berlinSecond = bConverter.getBerlinSecond(this.midnightTime);
		assertEquals(this.second.toString(), berlinSecond);
	}

	@Test
	public void testGetBerlinHour(){
		this.bConverter = new BerlinConverter();
		final String berlinHour = bConverter.getBerlinHour(this.midnightTime);
		assertEquals(this.hour.toString(), berlinHour);
	}

	@Test
	public void testGetBerlinMinute(){
		this.bConverter = new BerlinConverter();
		final String berlinMinute = bConverter.getBerlinMinute(this.midnightTime);
		assertEquals(this.minute.toString(), berlinMinute);
	}

}
