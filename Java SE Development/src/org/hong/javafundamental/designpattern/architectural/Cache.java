package org.hong.javafundamental.designpattern.architectural;

import java.util.ArrayList;
import java.util.List;

public class Cache {
	
	private final List<Service> services;
	
	public Cache() {
		services = new ArrayList<>();
	}
	
	public Service getService(String serviceName) {
		
		for (Service service : services) {
			if (service.getName().equals(serviceName)) {
				System.out.println("Returning cached " + serviceName + " object");
				return service;
			}
		}
		
		return null;
	}
	
	public void addService(Service newService) {
		boolean exists = false;
		
		for (Service service : services) {
			if (service.getName().equals(newService.getName())) {
				exists = true;
				break;
			}
		}
		
		if (!exists) {
			services.add(newService);
		}
	}
	
}
