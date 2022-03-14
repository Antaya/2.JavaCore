package com.javarush.task.task18.task1817;

import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;

/* 
Пробелы
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        String fileName = args[0];
        FileInputStream fileInputStream = new FileInputStream(fileName);
        int count = 0;
        int countSpace = 0;

        while (fileInputStream.available() > 0){
            int x = fileInputStream.read();
            count++;
            if(x == 32) {countSpace ++;}

        }
        fileInputStream.close();
       // System.out.println(count);
        //System.out.println(countSpace);

        Double characterRatio = (double)countSpace / count * 100;
        System.out.printf("%.2f", characterRatio);


    }
}
