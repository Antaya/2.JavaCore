package com.javarush.task.task18.task1825;

import java.io.*;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Set;
import java.util.TreeSet;

/* 
Собираем файл
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        TreeSet<String> files = new TreeSet<>();

        while (true) {
            String input = reader.readLine();
            if ("end".equals(input)) {
                break;
            }
            files.add(input);
        }
        reader.close();

        String firstFileName = files.first();
        FileOutputStream fileOutputStream = new FileOutputStream(firstFileName.substring(0, firstFileName.lastIndexOf('.')), true);

        for (String str : files) {
            FileInputStream fileInputStream = new FileInputStream(str);
            while (fileInputStream.available() > 0) {
                byte[] buffer = new byte[fileInputStream.available()];
                fileInputStream.read(buffer);
                fileOutputStream.write(buffer);
            }
            fileInputStream.close();
        }
        fileOutputStream.close();
    }
}
