package org.hong.javafundamental.designpattern.behavioral;

public interface LogHandler {
	
	public void handleLogMessage(LoggingMessage logMessage);
	public void setNextLogHandler(LogHandler logHandler);

}
