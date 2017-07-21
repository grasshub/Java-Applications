package org.hong.javafundamental.generics;

public class NaturalNumber<T extends Number> {

	private T n;

	public NaturalNumber(T n) {
		this.n = n;
	}

	public boolean isEven() {

		return n.intValue() % 2 == 0;
	}

}