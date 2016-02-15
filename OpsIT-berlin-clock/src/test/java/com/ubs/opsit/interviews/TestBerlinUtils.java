package com.ubs.opsit.interviews;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import com.ubs.opsit.interviews.exception.BerlinClockException;
import com.ubs.opsit.interviews.tools.BerlinUtils;
import com.ubs.opsit.interviews.tools.ExcType;

public class TestBerlinUtils {

	private String midnightTime;
	
	@Before
	public void setUp(){
		this.midnightTime = "00:00:00";
	}

	@Test
	public void testGetBerlinSecond(){
		try {
			assertEquals("Y", BerlinUtils.getBerlinSecond(this.midnightTime));
		} catch (BerlinClockException e) {
			fail("GetBerlinSecond failed!");
		}
	}

	@Test
	public void testGetBerlinHour(){
		try {
			final StringBuffer hour = new StringBuffer();
			hour.append("OOOO");
			hour.append(System.getProperty("line.separator"));
			hour.append("OOOO");
			assertEquals(hour.toString(), BerlinUtils.getBerlinHour(this.midnightTime));
		} catch (BerlinClockException e) {
			fail("GetBerlinHour failed!");
		}
	}

	@Test
	public void testGetBerlinMinute(){
		try {
			// Minute
			final StringBuffer minute = new StringBuffer();
			minute.append("OOOOOOOOOOO");
			minute.append(System.getProperty("line.separator"));
			minute.append("OOOO");
			assertEquals(minute.toString(), BerlinUtils.getBerlinMinute(this.midnightTime));
		} catch (BerlinClockException e) {
			fail("GetBerlinHour failed!");
		}
	}
	
	@Test
	public void testInputFailureOnSecond() {
		try {
			BerlinUtils.getBerlinMinute("01:02:60");
		} catch (BerlinClockException e) {
			assertEquals(ExcType.INPUT, e.getExcType());
		}
	}
	
	@Test
	public void testInputFailureOnHour() {
		try {
			BerlinUtils.getBerlinHour("25:00:00");
		} catch (BerlinClockException e) {
			assertEquals(ExcType.INPUT, e.getExcType());
		}
	}
	
	@Test
	public void testInputFailureOnMinute() {
		try {
			BerlinUtils.getBerlinMinute("01:60:00");
		} catch (BerlinClockException e) {
			assertEquals(ExcType.INPUT, e.getExcType());
		}
	}
}
