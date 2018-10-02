package com.hari.java.threads;

public class DemoThreadWS implements Runnable {
    @Override
    public void run() {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            System.out.println("Thread interrupted" + e.getMessage());
        }

        System.out.println("Harry " + WaitingState.t1.getState());
    }
}
