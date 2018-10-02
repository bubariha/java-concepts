package com.hari.java;

import com.hari.java.threads.*;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws InterruptedException {

        Scanner scanner = new Scanner(System.in);
        System.out.println("Please enter one anong [NEW, RUNNABLE, BLOCKED, WAITING, TIMED_WAITING, TERMINATED]");
        String thredState = scanner.next();
        switch (thredState) {
            case "NEW":
                newState();
                break;
            case "RUNNABLE":
                runnableState();
                break;
            case "BLOCKED":
                blockedState();
                break;
            case "WAITING":
                waitingState();
                break;
            case "TIMED_WAITING":
                timedWaitingState();
                break;
            case "TERMINATED":
                terminatedState();
                break;

        }
    }

    private static void terminatedState() throws InterruptedException {
        TerminatedState.t1 = new Thread(new TerminatedState());
        TerminatedState.t1.start();
        Thread.sleep(1000);
        System.out.println(TerminatedState.t1.getState());
    }

    private static void timedWaitingState() throws InterruptedException {

        TimedWaitingState.t1 = new Thread(new TimedWaitingState());
        TimedWaitingState.t1.start();
        Thread.sleep(1000);// This time should be less to the time in its child thread
        System.out.println(TimedWaitingState.t1.getState());
    }

    private static void waitingState() {
        WaitingState waitingState = new WaitingState();
        WaitingState.t1 = new Thread(waitingState);
        WaitingState.t1.start();
    }

    private static void blockedState() throws InterruptedException {
        Thread t1 = new Thread(new Blocked());
        Thread t2 = new Thread(new Blocked());
        t1.start();
        t2.start();
        Thread.sleep(1000);//Giving some time to both states and then checking those states: Here current thread is Main
        System.out.println("current thread in main method = " + Thread.currentThread());

        System.out.println("t2 = " + t2.getState());
        System.exit(0);
    }

    private static void runnableState() {
        Runnable runnable = new NewAndRunnable();
        Thread thread = new Thread(runnable);
        thread.start();
        System.out.println(thread.getState());
    }

    private static void newState() {
        Runnable runnable = new NewAndRunnable();
        Thread thread = new Thread(runnable);
        System.out.println(thread.getState());
    }
}
