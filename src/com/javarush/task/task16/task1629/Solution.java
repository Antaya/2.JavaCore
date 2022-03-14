package com.javarush.task.task16.task1629;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/* 
Только по-очереди!
*/

public class Solution {
    public static volatile BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws InterruptedException {

        Read3Strings t1 = new Read3Strings();
        Read3Strings t2 = new Read3Strings();

        //add your code here - добавьте код тут
        t1.start();
        t1.join();
        t1.printResult();
        t1.interrupt();

        t2.start();
        t2.join();
        t2.printResult();


        t2.interrupt();


    }

    //add your code here - добавьте код тут
    public static class Read3Strings extends Thread {
        private int count = 0;
        String result = "";

        @Override
        public void run() {
                try {
                    while (count < 3) {

                        result += reader.readLine() + " ";
                        count ++;


                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }



        public void printResult() {
            System.out.println(result);
        }
    }
}
