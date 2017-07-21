package org.hong.javafundamental.designpattern.behavioral;

public class ErrorLogHandler implements LogHandler {
	
	private LogHandler nextLogHandler;
	
	public void setNextLogHandler(LogHandler logHandler) {
		nextLogHandler = logHandler;
	}
	
	public void handleLogMessage(LoggingMessage logMessage) {
		if (logMessage.getLevel().equals(LoggingMessage.ERROR)) {
			System.out.println("Write the error logging message to debugging log file: " +logMessage.getMessage());
		}
		else
			nextLogHandler.handleLogMessage(logMessage);
	}

}
