package com.javarush.task.task18.task1809;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/* 
Реверс файла
*/

public class Solution {
    public static void main(String[] args) throws IOException {
               try (FileInputStream fileInputStream = new FileInputStream(new BufferedReader(new InputStreamReader(System.in)).readLine());
             FileOutputStream fileOutputStream = new FileOutputStream(new BufferedReader(new InputStreamReader(System.in)).readLine())){

            byte[] bytes = new byte[fileInputStream.available()];
            fileInputStream.read(bytes);

            for (int i = bytes.length - 1; i >= 0; i--) {
                fileOutputStream.write(bytes[i]);
            }
        }




    }
}
