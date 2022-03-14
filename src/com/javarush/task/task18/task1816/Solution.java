package com.javarush.task.task18.task1816;

import java.io.*;
/* 
Английские буквы
*/

public class Solution {
    public static void main(String[] args) throws IOException {

        String fileName = args[0];
        FileInputStream fileInputStream = new FileInputStream(fileName);
int count = 0;
          while (fileInputStream.available() > 0){
int x = fileInputStream.read();
if((x >= 64 && x <= 91)||(x >= 97 && x <= 122)) count ++;
          }
          fileInputStream.close();

        System.out.println(count);

    }
}
