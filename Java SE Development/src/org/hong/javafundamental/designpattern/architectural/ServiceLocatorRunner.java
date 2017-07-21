package org.hong.javafundamental.designpattern.architectural;

public class ServiceLocatorRunner {
	
	private static final String SERVICE = "ServiceImpl";
	private static final String SERVICEA = "ServiceImplA";
	private static final String SERVICEB = "ServiceImplB";

	public static void main(String[] args) {
		
		Service service = ServiceLocator.getService(SERVICE);
		if (service != null)
			service.execute();
		else 
			System.out.println("Could not find service: " + SERVICE);
		
		service = ServiceLocator.getService(SERVICEA);
		if (service != null)
			service.execute();
		else 
			System.out.println("Could not find service: " + SERVICEA);
		
		
		service = ServiceLocator.getService(SERVICE);
		if (service != null)
			service.execute();
		else 
			System.out.println("Could not find service: " + SERVICE);
		
		service = ServiceLocator.getService(SERVICEB);
		if (service != null)
			service.execute();
		else 
			System.out.println("Could not find service: " + SERVICEB);
		
	}

}
