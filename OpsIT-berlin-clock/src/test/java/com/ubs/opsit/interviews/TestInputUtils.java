package com.ubs.opsit.interviews;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

public class TestInputUtils {

	private String time;
	private String[] timeArr;
	
	@Before
	public void setUp() {
		this.time = "01:02:03";
		this.timeArr = new String[]{"01", "02", "03"};
	}

	@Test
	public void testGetHhMmSs() {
		assertArrayEquals(timeArr, InputUtils.getHhMmSs(time));
	}
	
	@Test
	public void testHasOnlyTwoDigits(){
		assertTrue(InputUtils.hasOnlyTwoDigits("00"));
		assertFalse(InputUtils.hasOnlyTwoDigits("0A"));
		assertFalse(InputUtils.hasOnlyTwoDigits("-0A"));
	}

	@Test
	public void testIsHourWithinBoundary(){
		assertTrue(InputUtils.isHourWithinBoundary("00"));
		assertTrue(InputUtils.isHourWithinBoundary("24"));
		assertFalse(InputUtils.isHourWithinBoundary("25"));
	}

	@Test
	public void testIsMinuteWithinBoundary(){
		assertTrue(InputUtils.isMinuteWithinBoundary("00"));
		assertTrue(InputUtils.isMinuteWithinBoundary("59"));
		assertFalse(InputUtils.isMinuteWithinBoundary("60"));
	}

	@Test
	public void testIsSecondWithinBoundary(){
		assertTrue(InputUtils.isSecondWithinBoundary("00"));
		assertTrue(InputUtils.isSecondWithinBoundary("59"));
		assertFalse(InputUtils.isSecondWithinBoundary("60"));
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void testHourBoundaryCheckFailure(){
		InputUtils.getHhMmSs("25:02:03");
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void testMinuteBoundaryCheckFailure(){
		InputUtils.getHhMmSs("23:60:03");
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void testSecondBoundaryCheckFailure(){
		InputUtils.getHhMmSs("23:59:60");
	}

}
