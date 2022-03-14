package com.javarush.task.task19.task1908;

import java.io.*;
import java.util.ArrayList;

/* 
Выделяем числа
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String fileName1 = reader.readLine();
        String fileName2 = reader.readLine();

        reader.close();


        BufferedReader fr = new BufferedReader(new FileReader(fileName1));
     BufferedWriter fw = new BufferedWriter(new FileWriter(fileName2));
        String line = "";
        while (fr.ready()){
            line = fr.readLine();
            String lineReplaced = line.replaceAll("\\p{P}", " ");
            String[] strings = lineReplaced.split(" ");
            for (String s : strings){

               try {
                 fw.write(String.valueOf(Integer.parseInt(s)) + " ");

               }catch (IllegalArgumentException e){
                   continue;
               }

            }
        }
        fr.close();
        fw.close();
    }
}
