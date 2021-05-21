package org.hong.javafundamental.designpattern.structural;

public class TeamLead extends EmployeeDecorator{
	
	public TeamLead(Employee employee) {
		super(employee);
	}

	public void motivate() {
		System.out.println(this.getClass().getName() + " is motivating his members.");
	}

	@Override
	public void dailyTask() {
		employee.dailyTask();
		leadTask();
	}
	
	public void leadTask() {
		System.out.println(this.getClass().getName() + " is performing lead's task.");
	}
}
