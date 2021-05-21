package org.hong.javafundamental.concurrent;

import java.util.Random;

public class AtomicIntegerRunner {

    static final int MAXIMUM = 20;
    static final int THREE_SECONDS = 3 * 1000;
    static final Random random = new Random();

    public static void main(String[] args) {

        final AtomicCounter count = new AtomicCounter();

        new Thread(() -> {
            for (int i = 0; i <= MAXIMUM; i++) {
                count.increment();
                try {
                    Thread.sleep(random.nextInt(THREE_SECONDS));
                } catch (InterruptedException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                    Thread.currentThread().interrupt();
                }
            }
        }).start();

        new Thread(() -> {
            for (int i = 0; i <= MAXIMUM; i++) {
                count.decrement();
                try {
                    Thread.sleep(random.nextInt(THREE_SECONDS));
                } catch (InterruptedException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                    Thread.currentThread().interrupt();
                }
            }
        }).start();

        new Thread(() -> {
            for (int i = 0; i <= MAXIMUM; i++) {
                System.out.println("The current count value is: " + count.get());
                try {
                    Thread.sleep(random.nextInt(THREE_SECONDS));
                } catch (InterruptedException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                    Thread.currentThread().interrupt();
                }
            }
        }).start();
    }

}
