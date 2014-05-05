package com.joragupra.disruptorSample;

public class LongEvent {

	private long value;

	public void set(long value) {
		this.value = value;
	}

	public String toString() {
		return "Event: " + value;
	}

}