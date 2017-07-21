package org.hong.javafundamental.designpattern.structural;

public class TeamManager extends EmployeeDecorator {
	
	public TeamManager(Employee employee) {
		super(employee);
	}
	
	public void submitBudget() {
			System.out.println(this.getClass().getName() + " is submitting the budget.");
	}

	public void dailyTask() {
		employee.dailyTask();
		managerTask();	
	}
	
	public void managerTask() {
		System.out.println(this.getClass().getName() + " is performing manager's task");
	}
}
