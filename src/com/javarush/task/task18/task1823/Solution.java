package com.javarush.task.task18.task1823;

import java.io.*;
import java.util.*;

/* 
Нити и байты
*/

public class Solution {
    public static Map<String, Integer> resultMap = new HashMap<String, Integer>();

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        while (true) {
            String input = reader.readLine();
            if ("exit".equals(input)) {
                break;
            }

            Thread th = new ReadThread(input);
            th.start();
            try {
                th.join();
            } catch (Exception e) {
            }
        }
        reader.close();

     //   System.out.println(resultMap);
    }


    public static class ReadThread extends Thread {
        private String fileName;

        public ReadThread(String fileName) {
            //implement constructor body
            this.fileName = fileName;
        }

        // implement file reading here - реализуйте чтение из файла тут

        @Override
        public void run() {
            try {
                FileInputStream fileInputStream = new FileInputStream(fileName);
                HashMap<Integer, Integer> bytes = new HashMap<>();
                int maxByte = 0;
                while (fileInputStream.available() > 0) {
                    int date = fileInputStream.read();
                    if (!bytes.containsKey(date)) {
                        bytes.put(date, 1);
                    } else bytes.put(date, bytes.get(date) + 1);
                }



                Set<Map.Entry<Integer, Integer>> entrySet = bytes.entrySet();

                int numMaxByte = Collections.max(bytes.values());//что хотим найти
                for (Map.Entry<Integer, Integer> pair : entrySet) {
                    if (numMaxByte == pair.getValue()) {
                        maxByte = pair.getKey();

                    }
                }

                synchronized (Solution.class) {
                    resultMap.put(fileName, maxByte);
                }
                fileInputStream.close();
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }


        }
    }
}
