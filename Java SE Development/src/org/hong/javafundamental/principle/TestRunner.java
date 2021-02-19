package org.hong.javafundamental.principle;

public class TestRunner {
    public static void main(String[] args) {
        Student student = new Student("John", 20);
        System.out.println("The student age is: " + student.getAge());
        // Can not access private variable directly.
        // System.out.println("The student age is: " + student.age);
    }
}
