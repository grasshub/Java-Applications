package org.hong.javafundamental.designpattern.structural;

public class TeamMember extends EmployeeDecorator {

	public TeamMember(Employee employee) {
		super(employee);
	}

	public void performTask() {
		System.out.println(this.getClass().getName() + " is performing his assigned tasks.");
	}
	
	public void dailyTask() {
		employee.dailyTask();
		memberTask();
	}
	
	public void memberTask() {
		System.out.println(this.getClass().getName() + " is performing member's task.");
	}

}
