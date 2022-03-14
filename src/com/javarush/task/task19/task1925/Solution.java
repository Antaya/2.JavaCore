package com.javarush.task.task19.task1925;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

/* 
Длинные слова
*/

public class Solution {
    public static void main(String[] args) throws IOException {

           BufferedReader fr = new BufferedReader(new FileReader(args[0]));
       FileWriter fw = new FileWriter(args[1]);
       ArrayList <String> strings = new ArrayList<>();
       while (fr.ready()){
           String line = fr.readLine();

           String[]str = line.split(" ");
           for (String s : str){
               if(s.length()  > 6){
                   strings.add(s);
                  }
           }
           }
        fr.close();

       if (strings.size() != 1) {
           for (int i = 0; i < strings.size() - 1; i++) {
               fw.write(strings.get(i) + ",");
           }
           fw.write(strings.get(strings.size()-1));
       } else fw.write(strings.get(0));

       fw.close();

    }
}
