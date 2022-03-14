package com.javarush.task.task19.task1907;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;

/* 
Считаем слово
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String fileName = reader.readLine();
        reader.close();


        BufferedReader fr = new BufferedReader(new FileReader(fileName));
        String line = "";
        int count = 0;
        while (fr.ready()){
            line = fr.readLine();
            String lineReplaced = line.replaceAll("\\p{P}", " ");
            String[] strings = lineReplaced.split(" ");
            for (String s : strings){

            if (s.equals("world")) {
                count++;
            }

        }
        }
        fr.close();
        System.out.println(count);
    }
}
