package org.hong.javafundamental.designpattern.architectural;

public class ServiceLocator {
	
	private static final Cache cache;
	
	static {
		cache = new Cache();
	}

	private ServiceLocator() {}
	
	public static Service getService(String jndiName) {
		
		Service service = cache.getService(jndiName);
		
		if (service != null) {
			return service;
		}
		
		InitialContext context = new InitialContext();
		Service newService = (Service) context.lookup(jndiName);
		if (newService != null)
			cache.addService(newService);
		return newService;
	}

}
