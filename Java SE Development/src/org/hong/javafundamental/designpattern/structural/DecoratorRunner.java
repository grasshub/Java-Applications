package org.hong.javafundamental.designpattern.structural;

import java.util.Date;

//This example uses the Decorator pattern

public class DecoratorRunner {
	
	public static void main(String[] args) {
		
		Employee employee = new EmployeeImpl();
		// Assign all three roles to employee
		employee = new TeamMember(employee);
		employee = new TeamLead(employee);
		employee = new TeamManager(employee);
		
		// daily task will include three roles tasks
		employee.dailyTask();

		// also can invoke method in base class
		employee.join(new Date());
		employee.terminate(new Date());
		
		// use role specific method on role specific type 
		Employee empl = new EmployeeImpl();
		TeamLead teamLead = new TeamLead(empl);
		teamLead.motivate();
		teamLead.dailyTask();
		
		TeamManager teamManager = new TeamManager(empl);
		teamManager.submitBudget();
		teamManager.dailyTask();
		
	}

}
