package org.hong.javafundamental.designpattern.structural;

import java.util.Date;

public interface Employee {

	public void join(Date joinDate);
	public void terminate(Date terminateDate);
	public void dailyTask();

	// other behaviors may reside (see sample code)
}
