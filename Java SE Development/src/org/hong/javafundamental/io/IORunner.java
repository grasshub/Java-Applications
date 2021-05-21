package org.hong.javafundamental.io;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Calendar;
import java.util.GregorianCalendar;

public class IORunner {
	
	public static void main(String[] arg) {
		
		String fileName = "Java SE Development/Data File/ObjectOutput.ser";
		String separator = "/";
		
		Employee employee = new Employee("John Doe", 100000, new GregorianCalendar(1965, 5, 8));
		
		FileOutputStream fos;
		ObjectOutputStream oos = null;
		try {
			fos = new FileOutputStream(new File(fileName));
			oos = new ObjectOutputStream(fos);
			oos.writeObject(employee);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if (oos != null)
					oos.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
		FileInputStream fis;
		ObjectInputStream ois = null;
		Employee emp = null;
		
		try {
			fis = new FileInputStream(new File(fileName));
			ois = new ObjectInputStream(fis);
			emp = (Employee)ois.readObject();
		} catch (ClassNotFoundException | IOException e1) {
			e1.printStackTrace();
		} finally {
			try {
				if (ois != null)
					ois.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
		if (emp != null) {
			System.out.println("Name: " + emp.getName());
			System.out.println("Salary: " + emp.getSalary());
			System.out.println("Join Date: " + emp.getJoinDate().get(Calendar.MONTH) + separator + employee.getJoinDate().get(Calendar.DAY_OF_MONTH) + separator + employee.getJoinDate().get(Calendar.YEAR));
		}
	}

}
