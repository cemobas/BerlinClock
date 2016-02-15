package com.ubs.opsit.interviews;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import org.junit.Test;

import com.ubs.opsit.interviews.exception.IllegalTimeInputException;
import com.ubs.opsit.interviews.tools.ExcType;
import com.ubs.opsit.interviews.tools.InputUtils;

public class TestInputUtils {

	@Test
	public void testGetHhMmSs() {
		try {
			assertArrayEquals(new String[] { "01", "02", "03" },
					InputUtils.getHhMmSs("01:02:03"));
		} catch (IllegalTimeInputException e) {
			fail("Test failed.");
		}
	}

	@Test
	public void testWhenOneSeparatorIsMissing() {
		final String value = "0101:60";
		try {
			InputUtils.getHhMmSs(value);
		} catch (IllegalTimeInputException e) {
			assertEquals(ExcType.FORMAT,
					e.getExcType());
			assertEquals(value, e.getValue());
		}
	}

	@Test
	public void testWhenInputIsOverloadedWithAdditionalSection() {
		final String value = "01:01:60:00";
		try {
			InputUtils.getHhMmSs(value);
		} catch (IllegalTimeInputException e) {
			assertEquals(ExcType.FORMAT,
					e.getExcType());
			assertEquals(value, e.getValue());
		}
	}

	@Test
	public void testTwoDigitsHourViolation() {
		final String value = "A0:02:03";
		try {
			InputUtils.getHhMmSs(value);
		} catch (IllegalTimeInputException e) {
			assertEquals(ExcType.HOUR,
					e.getExcType());
			assertEquals("A0", e.getValue());
		}
	}

	@Test
	public void testTwoDigitsMinuteViolation() {
		final String value = "01:0A:03";
		try {
			InputUtils.getHhMmSs(value);
		} catch (IllegalTimeInputException e) {
			assertEquals(ExcType.MINUTE,
					e.getExcType());
			assertEquals("0A", e.getValue());
		}
	}

	@Test
	public void testTwoDigitsSecondViolation() {
		final String value = "01:02:0A";
		try {
			InputUtils.getHhMmSs(value);
		} catch (IllegalTimeInputException e) {
			assertEquals(ExcType.SECOND,
					e.getExcType());
			assertEquals("0A", e.getValue());
		}
	}

	@Test
	public void testHourBoundaryCheckFailure() {
		try {
			InputUtils.getHhMmSs("25:02:03");
		} catch (IllegalTimeInputException e) {
			assertEquals(ExcType.HOUR,
					e.getExcType());
			assertEquals("25", e.getValue());
		}
	}

	@Test
	public void testMinuteBoundaryCheckFailure() {
		try {
			InputUtils.getHhMmSs("23:60:03");
		} catch (IllegalTimeInputException e) {
			assertEquals(ExcType.MINUTE,
					e.getExcType());
			assertEquals("60", e.getValue());
		}
	}

	@Test
	public void testSecondBoundaryCheckFailure() {
		try {
			InputUtils.getHhMmSs("23:59:60");
		} catch (IllegalTimeInputException e) {
			assertEquals(ExcType.SECOND,
					e.getExcType());
			assertEquals("60", e.getValue());
		}
	}

}
