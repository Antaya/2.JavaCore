package com.javarush.task.task18.task1805;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.*;

/* 
Сортировка байт
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        FileInputStream fileInputStream = new FileInputStream(reader.readLine());
        reader.close();

        List<Integer> bytes = new ArrayList<>();

        while (fileInputStream.available() > 0){
            int date = fileInputStream.read();
            if(!bytes.contains(date)){
                bytes.add(date);
            }

        }
        fileInputStream.close();

        Collections.sort(bytes);
        for(int i : bytes){
            System.out.print(i + " ");
        }


    }
}
