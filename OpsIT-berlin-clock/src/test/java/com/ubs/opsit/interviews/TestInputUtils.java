package com.ubs.opsit.interviews;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import com.ubs.opsit.interviews.exception.IllegalTimeInputException;

public class TestInputUtils {

	@Test
	public void testGetHhMmSs() {
		assertArrayEquals(new String[]{"01", "02", "03"}, InputUtils.getHhMmSs("01:02:03"));
	}
	
	@Test(expected=IllegalTimeInputException.class)
	public void testWhenInputHasLessThanEightCharacters() {
		InputUtils.getHhMmSs("0101:60");
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
	
	@Test(expected=IllegalTimeInputException.class)
	public void testHourBoundaryCheckFailure(){
		InputUtils.getHhMmSs("25:02:03");
	}
	
	@Test(expected=IllegalTimeInputException.class)
	public void testMinuteBoundaryCheckFailure(){
		InputUtils.getHhMmSs("23:60:03");
	}
	
	@Test(expected=IllegalTimeInputException.class)
	public void testSecondBoundaryCheckFailure(){
		InputUtils.getHhMmSs("23:59:60");
	}
	
	@Test(expected=IllegalTimeInputException.class)
	public void testWhenInputHasNonDigitCharacters() {
		InputUtils.getHhMmSs("AA:AA:60");
	}

}
