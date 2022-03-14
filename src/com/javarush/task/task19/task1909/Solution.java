package com.javarush.task.task19.task1909;

import java.io.*;
import java.util.ArrayList;

/* 
Замена знаков
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
        while (fr.ready()) {
            line = fr.readLine();
            String lineReplaced = line.replace(".", "!");
            fw.write(lineReplaced);

        }
        fr.close();
        fw.close();
    }
}
