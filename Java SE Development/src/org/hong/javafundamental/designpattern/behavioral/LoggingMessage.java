package org.hong.javafundamental.designpattern.behavioral;

public class LoggingMessage {

	private String message;
	private String level;
	public static final String INFORMATION = "information";
	public static final String ERROR = "error";
	public static final String CRITICAL_ERROR = "critical error";
	
	public LoggingMessage(String message, String level) {
		this.message = message;
		this.level = level;
	}
	
	public String getMessage() {
		return message;
	}
	
	public String getLevel() {
		return level;
	}
}
