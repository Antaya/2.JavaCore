package com.javarush.task.task16.task1619;

/* 
А без interrupt слабо?
*/

public class Solution {
    private static boolean isOurInterruptMethod;

    public static void main(String[] args) throws InterruptedException {
        Thread t = new Thread(new TestThread());
        t.start();
        Thread.sleep(3000);
        ourInterruptMethod();

    }

    public static void ourInterruptMethod() {

        isOurInterruptMethod = true;
    }

    public static class TestThread implements Runnable {
        public void run() {

            try {
                while (!isOurInterruptMethod) {

                    System.out.println("he-he");
                    Thread.sleep(500);

                }
            } catch (InterruptedException e) {
            }
        }
    }
}


