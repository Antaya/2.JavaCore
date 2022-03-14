package com.javarush.task.task16.task1630;

import java.io.*;
import java.util.Scanner;

/* 
Последовательный вывод файлов
*/

public class Solution {
    public static String firstFileName;
    public static String secondFileName;

    //add your code here - добавьте код тут
    static {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        try {
            firstFileName = reader.readLine();
            secondFileName = reader.readLine();
            //   FileInputStream fis1 =  new FileInputStream(firstFileName);
            //  FileInputStream fis2 =  new FileInputStream(secondFileName);
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public static void main(String[] args) throws InterruptedException {
        systemOutPrintln(firstFileName);
        systemOutPrintln(secondFileName);
    }

    public static void systemOutPrintln(String fileName) throws InterruptedException {
        ReadFileInterface f = new ReadFileThread();
        f.setFileName(fileName);
        f.start();
        //add your code here - добавьте код тут
        f.join();
        System.out.println(f.getFileContent());
    }

    public interface ReadFileInterface {

        void setFileName(String fullFileName);

        String getFileContent();

        void join() throws InterruptedException;

        void start();
    }

    //add your code here - добавьте код тут

    public static class ReadFileThread extends Thread implements ReadFileInterface {
        private String fullFileName = null;
        private String result = "";
        FileInputStream fis = null;


        @Override
        public void setFileName(String fullFileName) {
            this.fullFileName = fullFileName;

        }

        @Override
        public String getFileContent() {
            return result;
        }

        @Override
        public void run() {

            try {
                fis = new FileInputStream(fullFileName);
                Scanner sc = new Scanner(fis);
                while (sc.hasNext()) {
                    result += sc.next()+ " ";

                }

                sc.close();

            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
        }
    }

}
