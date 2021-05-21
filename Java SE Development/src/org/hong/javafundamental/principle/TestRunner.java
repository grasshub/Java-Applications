package org.hong.javafundamental.principle;

import java.util.logging.Logger;

public class TestRunner {
    static Logger logger = Logger.getLogger(TestRunner.class.getName());

    public static void main(String[] args) {
        Student student = new Student("John", 20);
        logger.info("The student age is: " + student.getAge());
        // Can not access private variable directly.
        // System.out.println("The student age is: " + student.age);
    }
}
