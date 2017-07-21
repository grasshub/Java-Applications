package org.hong.javafundamental.designpattern.behavioral;

public class ChainOfResponsibilityRunner {
	
	public static void main(String[] args) {
		
		//Set the chain of responsibility
		LogHandler informationLogHandler = new InformationLogHandler();
		LogHandler errorLogHandler = new ErrorLogHandler();
		LogHandler criticalErrorLogHandler = new CriticalErrorLogHandler();
		
		informationLogHandler.setNextLogHandler(errorLogHandler);
		errorLogHandler.setNextLogHandler(criticalErrorLogHandler);
		
		informationLogHandler.handleLogMessage(new LoggingMessage("Executing the method setName", LoggingMessage.INFORMATION));
		informationLogHandler.handleLogMessage(new LoggingMessage("Error at method setName", LoggingMessage.ERROR));
		informationLogHandler.handleLogMessage(new LoggingMessage("Critical at method setName", LoggingMessage.CRITICAL_ERROR));
			
		errorLogHandler.handleLogMessage(new LoggingMessage("Critical at method setName", LoggingMessage.CRITICAL_ERROR));
		errorLogHandler.handleLogMessage(new LoggingMessage("Executing the method setName", LoggingMessage.INFORMATION));
	}

}
