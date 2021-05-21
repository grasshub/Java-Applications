package org.hong.javafundamental.junit;

import java.util.logging.Level;
import java.util.stream.Stream;
import java.util.logging.Logger;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;

public class PrimeNumberTest {

	Logger logger = Logger.getLogger(PrimeNumberTest.class.getName());

	static Stream<Arguments> primeNumbers = Stream.of(
			Arguments.of(2, true),
			Arguments.of(4, false),
			Arguments.of(5, true),
			Arguments.of(6, false),
			Arguments.of(8, false),
			Arguments.of(9, false)
	);
	
	@ParameterizedTest
	@VariableSource("primeNumbers")
	public void validatePrimeNumbers(int number, boolean isPrime) {
		logger.log(Level.INFO, "Parameterized test with parameters: {0} {1}", new Object[] { number, isPrime });
		assertEquals(isPrime, PrimeNumber.isPrime(number));	
	}

}
