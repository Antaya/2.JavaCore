package com.javarush.task.task16.task1632;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/* 
Клубок
*/

public class Solution {
    public static List<Thread> threads = new ArrayList<>(5);

    static {

        threads.add(new Thread1());
        threads.add(new Thread2());

        threads.add(new Thread3());
        threads.add(new Thread4());
        threads.add(new Thread5());
    }

    public static void main(String[] args) throws InterruptedException {
        //  threads.get(0).start();

        // threads.get(1).start();
        //   Thread.sleep(2000);
        //   threads.get(1).interrupt();
        //  threads.get(2).start();
        //threads.get(3).start();
        //Thread.sleep(2000);
        //((Message) threads.get(3)).showWarning();
        //   threads.get(4).start();

    }

    public static class Thread1 extends Thread {
        @Override
        public void run() {
            while (true) {
            }
        }
    }


    public static class Thread2 extends Thread {
        @Override
        public void run() {
            try {
                throw new InterruptedException();

            } catch (InterruptedException e) {
                System.out.println(e);
            }

        }
    }


    public static class Thread3 extends Thread {
        public void run() {
            try {
                while (!Thread.currentThread().isInterrupted()) {
                    System.out.println("Ура");
                    Thread.sleep(500);

                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }
    }

    public static class Thread4 extends Thread implements Message {


        public void run() {
            while (!isInterrupted()) {
            }
        }

        @Override
        public void showWarning() {
            this.interrupt();
        }
    }

    public static class Thread5 extends Thread {


        public void run() {
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            int number = 0;
            while (true) {

                try {
                    String input = reader.readLine();
                    if ("N".equals(input))
                        break;
                    number += Integer.parseInt(input);

                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            System.out.println(number);

        }
    }
}



