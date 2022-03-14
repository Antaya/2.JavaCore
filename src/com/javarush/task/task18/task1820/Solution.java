package com.javarush.task.task18.task1820;

import java.io.*;

/* 
Округление чисел
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String fileName1 = reader.readLine();
        String fileName2 = reader.readLine();
        reader.close();
        FileReader fr = new FileReader(fileName1);
        FileWriter fw = new FileWriter(fileName2);

        BufferedReader readerFile = new BufferedReader(fr);
        String line = readerFile.readLine();


        fr.close();
        readerFile.close();

        String[] nbs = line.split(" ");
        for (int i = 0; i < nbs.length; i++) {

            double n = Double.parseDouble(nbs[i]);
            int result = Math.toIntExact(Math.round(n));
            fw.write(result + " ");
        }

        fw.close();
    }
}
