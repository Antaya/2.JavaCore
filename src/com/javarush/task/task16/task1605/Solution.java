package com.javarush.task.task16.task1605;

import java.util.Date;

/* 
Поговорим о музыке
*/

public class Solution {
    public static int delay = 1000;

    public static void main(String[] args) {
        Thread violin = new Thread(new Violin("Player"));
        violin.start();
    }

    public static void sleepNSeconds(int n) {
        try {
            Thread.sleep(n * delay);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public interface MusicalInstrument extends Runnable {
        Date startPlaying();

        Date stopPlaying();
    }

    public static class Violin implements MusicalInstrument{
        private String owner;

        public Violin(String owner) {
            this.owner = owner;
        }

        public Date startPlaying() {
          System.out.println(this.owner + " is starting to play");
            return new Date();
        }

        public Date stopPlaying() {
           System.out.println(this.owner + " is stopping playing");
            return new Date();
        }

        public void timePlaying(int time){
            Date start = startPlaying();
            sleepNSeconds(time);
            Date stop = stopPlaying();
            long timePlaying = stop.getTime() - start.getTime();

            System.out.println("Playing " + timePlaying + " ms");
        }

        @Override
        public void run() {
          timePlaying(1);
        }
    }
}
