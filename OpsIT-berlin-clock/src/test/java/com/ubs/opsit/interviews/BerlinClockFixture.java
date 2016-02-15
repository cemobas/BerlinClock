package com.ubs.opsit.interviews;

import static com.ubs.opsit.interviews.support.BehaviouralTestEmbedder.aBehaviouralTestRunner;
import static org.assertj.core.api.Assertions.assertThat;

import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * Acceptance test class that uses the JBehave (Gerkin) syntax for writing
 * stories. You will notice the TimeConverter has no implementation ... (hint)
 */
public class BerlinClockFixture {

	private TimeConverter berlinClock;
	private String theTime;

	@Before
	public void setUp() {
		this.berlinClock = new BerlinConverter();
	}

	@After
	public void tearDown() {
		this.berlinClock = null;
	}

	@Test
	public void berlinClockAcceptanceTests() throws Exception {
		aBehaviouralTestRunner().usingStepsFrom(this)
				.withStory("berlin-clock.story").run();
	}

	@When("the time is $time")
	public void whenTheTimeIs(String time) {
		theTime = time;
	}

	@Then("the clock should look like $")
	public void thenTheClockShouldLookLike(String theExpectedBerlinClockOutput) {
		assertThat(berlinClock.convertTime(theTime)).isEqualTo(
				theExpectedBerlinClockOutput);
	}
}
