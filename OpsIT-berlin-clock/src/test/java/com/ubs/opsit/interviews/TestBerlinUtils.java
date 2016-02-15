package com.ubs.opsit.interviews;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import com.ubs.opsit.interviews.tools.BerlinUtils;

public class TestBerlinUtils {

	private String midnightTime;
	private StringBuffer midnightBerlin;
	private StringBuffer second;
	private StringBuffer hour;
	private StringBuffer minute;
	
	@Before
	public void setUp(){
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
		assertEquals(this.second.toString(), BerlinUtils.getBerlinSecond(this.midnightTime));
	}

	@Test
	public void testGetBerlinHour(){
		assertEquals(this.hour.toString(), BerlinUtils.getBerlinHour(this.midnightTime));
	}

	@Test
	public void testGetBerlinMinute(){
		assertEquals(this.minute.toString(), BerlinUtils.getBerlinMinute(this.midnightTime));
	}
}
