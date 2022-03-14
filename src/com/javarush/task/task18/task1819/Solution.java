package com.javarush.task.task18.task1819;

import java.io.*;

/* 
Объединение файлов
*/

public class Solution {
    public static void main(String[] args) throws IOException {
BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
String fileName1 = reader.readLine();
String fileName2 = reader.readLine();

reader.close();
FileInputStream fileInputStream1 = new FileInputStream(fileName1);
        byte[]buff1 = new byte[fileInputStream1.available()];
       while (fileInputStream1.available() > 0){
    fileInputStream1.read(buff1);
}
       fileInputStream1.close();



FileOutputStream fileOutputStream = new FileOutputStream(fileName1);
FileInputStream fileInputStream2 = new FileInputStream(fileName2);
        byte[]buff2 = new byte[fileInputStream2.available()];

while (fileInputStream2.available() > 0){
    fileInputStream2.read(buff2);
}

        fileInputStream2.close();
       ByteArrayOutputStream baos = new ByteArrayOutputStream();
baos.write(buff2);
baos.write(buff1);

baos.writeTo(fileOutputStream);
fileOutputStream.close();
baos.close();
    }
}
