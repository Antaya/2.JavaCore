package com.javarush.task.task19.task1926;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;

/* 
Перевертыши
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String fileName = reader.readLine();
        reader.close();

        BufferedReader fr = new BufferedReader(new FileReader(fileName));
        while (fr.ready()){
            String line = fr.readLine();
            StringBuilder sb = new StringBuilder(line);
            String revString = sb.reverse().toString();
            System.out.println(revString);
        }
        fr.close();
    }
}
