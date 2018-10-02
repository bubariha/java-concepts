package com.hari.java.threads;

public class WaitingState implements Runnable {

    public static Thread t1;

    @Override
    public void run() {
        Thread t2 = new Thread(new DemoThreadWS());
        t2.start();

        try {
            t2.join();
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            System.out.println("Thread interrupted" + e.getMessage());
        }
    }
}
