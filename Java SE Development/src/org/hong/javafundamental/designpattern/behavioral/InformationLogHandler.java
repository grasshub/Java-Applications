package org.hong.javafundamental.designpattern.behavioral;

public class InformationLogHandler implements LogHandler {
	
	private LogHandler nextLogHandler;
	
	public void setNextLogHandler(LogHandler logHandler) {
		nextLogHandler = logHandler;
	}
	
	public void handleLogMessage(LoggingMessage logMessage) {
		if (logMessage.getLevel().equals(LoggingMessage.INFORMATION)) {
			System.out.println("Write the informational logging message to debugging log file: " + logMessage.getMessage());
		}
		else
			nextLogHandler.handleLogMessage(logMessage);
	}
	
}
