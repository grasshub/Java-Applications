package org.hong.javafundamental.designpattern.structural;

import java.util.Date;

public interface Employee {

	void join(Date joinDate);
	void terminate(Date terminateDate);
	void dailyTask();

	// other behaviors may reside (see sample code)
}
