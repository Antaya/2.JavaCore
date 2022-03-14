package com.javarush.task.task18.task1802;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

/* 
Минимальный байт
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        FileInputStream fis = new FileInputStream(reader.readLine());
        reader.close();
        int minimumByte = 1000;

        while (fis.available() > 0) {
            int date = fis.read();
            if (date < minimumByte) {
                minimumByte = date;
            }
        }
        fis.close();
        System.out.println(minimumByte);
    }
}
