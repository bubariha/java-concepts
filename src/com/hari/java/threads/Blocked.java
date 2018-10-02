package com.hari.java.threads;

public class Blocked implements Runnable {
    static int n = 1;

    @Override
    public void run() {
        System.out.println("This is Blocked..!!!!");
        commonResource();
    }

    public static synchronized void commonResource() {

        while (true) {
            System.out.println("Thread: " + Thread.currentThread().getName() + ", n= " + n);
        }
    }
}
