package org.hong.javafundamental.designpattern.structural;

import java.util.Date;

public class EmployeeImpl implements Employee { 

	// other behaviors and properties may reside (see sample code)
	public void join(Date joinDate){
		System.out.println(this.getClass().getName() + " joined on " + joinDate);
	}

	public void terminate(Date terminateDate){
		System.out.println(this.getClass().getName() + " terminate on " + terminateDate);
	}
	
	public void dailyTask() {
		System.out.println(this.getClass().getName() + " is performing daily task");
	}
	
}
