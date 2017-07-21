package org.hong.javafundamental.designpattern.behavioral;

public class CriticalErrorLogHandler implements LogHandler {
	
	//private LogHandler nextLogHandler;
	
	public void setNextLogHandler(LogHandler logHandler) {
		//nextLogHandler = logHandler;
	}
	
	public void handleLogMessage(LoggingMessage logMessage) {
		if (logMessage.getLevel().equals(LoggingMessage.CRITICAL_ERROR)) {
			System.out.println("Write the critical logging message to debugging log file: " +logMessage.getMessage());
			System.out.println("Send an email regarding to this critical error: " + logMessage.getMessage());
		}
	}

}
