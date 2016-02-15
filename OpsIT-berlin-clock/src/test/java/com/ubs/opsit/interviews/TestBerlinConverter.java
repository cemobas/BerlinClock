package com.ubs.opsit.interviews;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class TestBerlinConverter {

	@Test
	public void testConvertTime() {
		final StringBuffer midnightBerlin = new StringBuffer();
		midnightBerlin.append("O");
		midnightBerlin.append("\r\n");
		midnightBerlin.append("RROO");
		midnightBerlin.append("\r\n");
		midnightBerlin.append("RRRO");
		midnightBerlin.append("\r\n");
		midnightBerlin.append("YYROOOOOOOO");
		midnightBerlin.append("\r\n");
		midnightBerlin.append("YYOO");
		BerlinConverter bc = new BerlinConverter();
		assertEquals(midnightBerlin.toString(), bc.convertTime("13:17:01"));
	}

}
