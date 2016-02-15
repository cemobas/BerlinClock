package com.ubs.opsit.interviews.tools;

/**
 * Each failure type corresponds to an Exception type.
 * @author CEMOBAS
 *
 */
public enum ExcType {
	HOUR("Incorrect hour format: "), MINUTE("Incorrect minute format: "), SECOND(
			"Incorrect second format: "), FORMAT(
			"Input doesn't fit HH:MM:SS format: ");

	private String phrase;

	ExcType(final String phrase) {
		this.setPhrase(phrase);
	}

	/**
	 * Returns phrase
	 * @return
	 */
	public String getPhrase() {
		return phrase;
	}

	/**
	 * Sets phrase
	 * @param phrase
	 */
	public void setPhrase(String phrase) {
		this.phrase = phrase;
	}
}
