package com.hari.java.threads;

public class TimedWaitingState implements Runnable {
    public static Thread t1;

    @Override
    public void run() {
        t1 = new Thread(new DemoThreadTWS());
        t1.start();
    }
}
