package com.javarush.task.task18.task1801;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

/* 
Максимальный байт
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        FileInputStream fis = new FileInputStream(reader.readLine());
        reader.close();
int maximumByte = 0;
        while (fis.available()>0){
            int data = fis.read();
            if(maximumByte < data){
                maximumByte = data;
            }

        }

        fis.close();
        System.out.println(maximumByte);

    }
}
