package com.ubs.opsit.interviews.tools;

public enum ExcType {
	INPUT("Incorrect value: ");
	
	private String phrase;
	
	ExcType(final String phrase) {
		this.setPhrase(phrase);
	}

	public String getPhrase() {
		return phrase;
	}

	public void setPhrase(String phrase) {
		this.phrase = phrase;
	}
}
