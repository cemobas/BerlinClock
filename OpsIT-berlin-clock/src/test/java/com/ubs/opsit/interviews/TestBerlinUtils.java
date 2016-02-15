package com.ubs.opsit.interviews;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.ubs.opsit.interviews.tools.BerlinUtils;

public class TestBerlinUtils {

	@Test
	public void testGetBerlinSecond() {
		assertEquals("Y", BerlinUtils.getBerlinSecond(0));
	}

	@Test
	public void testGetBerlinHour() {
		final StringBuffer hour = new StringBuffer();
		hour.append("OOOO");
		hour.append("\r\n");
		hour.append("OOOO");
		assertEquals(hour.toString(), BerlinUtils.getBerlinHour(0));
	}

	@Test
	public void testGetBerlinMinute() {
		final StringBuffer minute = new StringBuffer();
		minute.append("OOOOOOOOOOO");
		minute.append("\r\n");
		minute.append("OOOO");
		assertEquals(minute.toString(), BerlinUtils.getBerlinMinute(0));
	}
}
