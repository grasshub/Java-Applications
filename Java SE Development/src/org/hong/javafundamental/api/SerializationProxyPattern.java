package org.hong.javafundamental.api;

import java.io.Serializable;
import java.util.EnumSet;

public class SerializationProxyPattern {
	
	// Put writeReplace method on enclosing class EnumSet<E>
	// private Object writeReplace() {
	//		   return SerializationProxy(this);
    // }
	
	// EnumSet's Serialization Proxy
	private static class SerializationProxy<E extends Enum<E>> 
		implements Serializable {
		private final Class<E> elementType;
		private final Enum<?>[] elements;
		private static final long serialVersionUID = 1;
		
		SerializationProxy(EnumSet<E> set) {
			// set.elementType and ZERO_LENGTH_ENUM_ARRAY are EnumSet<E> fields
			elementType = null; //set.elementType;
			elements = null; // set.toArray(ZERO_LENGTH_ENUM_ARRAY);
		}
		
		// Put a readResolve method on the proxy
		// Use any methods in the public API of the enclosing class to
		// reconstitute instance
		private Object readResolve() {
			EnumSet<E> result = EnumSet.noneOf(elementType);
			for (Enum e: elements) {
				result.add((E)e);
			}
			
			return result;
		}
		
	}

	public static void main(String[] args) {

	}

}
