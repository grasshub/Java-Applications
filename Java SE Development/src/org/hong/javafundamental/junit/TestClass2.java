package org.hong.javafundamental.junit;

import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Timeout;

import java.util.logging.Logger;

public class TestClass2 {
    Logger logger = Logger.getLogger(TestClass2.class.getName());

    @Test
    public void dividedByZero() {
        assertThrows(ArithmeticException.class, () -> {
            int i = 1 / 0;
        });
    }

    @Disabled("Method is not ready to run")
    @Test
    void addNumber() {
        logger.info("Method is not ready to run!");
    }

    @Test
    @Timeout(1)
    public void infinity() {
        while (true);
    }

}
