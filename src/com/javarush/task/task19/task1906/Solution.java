package com.javarush.task.task19.task1906;

import java.io.*;
import java.util.ArrayList;

/* 
Четные символы
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String fileName1 = reader.readLine();
        String fileName2 = reader.readLine();
        reader.close();

        FileReader fr = new FileReader(fileName1);
        FileWriter fw = new FileWriter(fileName2);
        int counter = 1;

        while (fr.ready()) {
           int i = fr.read();
            if(counter % 2 == 0) {
                fw.write(i);
            }
            counter += 1;
        }
        fr.close();
        fw.close();
        }

    }




