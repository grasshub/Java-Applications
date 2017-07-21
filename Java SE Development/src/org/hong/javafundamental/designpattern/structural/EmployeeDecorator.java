package org.hong.javafundamental.designpattern.structural;

import java.util.Date;

public class EmployeeDecorator implements Employee {

	public Employee employee;

	public EmployeeDecorator(Employee employee) {
		this.employee = employee;
	}

	// other behaviors may reside (see sample code)

	public void join(Date joinDate) {
		employee.join(joinDate);
	}

	public void terminate(Date terminateDate) {
		employee.terminate(terminateDate);
	}
	
	public void dailyTask() {
		employee.dailyTask();
	}
	
}
