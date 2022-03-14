package com.javarush.task.task13.task1318;

import java.io.*;
import java.util.Scanner;

/* 
Чтение файла
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        // напишите тут ваш код
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String fileName = reader.readLine();
        InputStream fileInputStream = null;
        BufferedInputStream buffer = null;

        try {
            fileInputStream = new FileInputStream(fileName);
            buffer = new BufferedInputStream(fileInputStream);

            while (buffer.available() > 0) {

                char c = (char) buffer.read();



                System.out.print(c);
            }
        } catch (Exception e) {

            e.printStackTrace();

        } finally {

            fileInputStream.close();
            reader.close();
        }
    }
}