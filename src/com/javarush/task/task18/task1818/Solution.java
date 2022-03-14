 package com.javarush.task.task18.task1818;

import java.io.*;

/* 
Два в одном
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String fileName1 = reader.readLine();
        String fileName2 = reader.readLine();
        String fileName3 = reader.readLine();

        reader.close();

FileOutputStream fileOutputStream = new FileOutputStream(fileName1, true);
FileInputStream fileInputStream1 = new FileInputStream(fileName2);
FileInputStream fileInputStream2 = new FileInputStream(fileName3);


        while (fileInputStream1.available() > 0){
     int date1 = fileInputStream1.read();
    fileOutputStream.write(date1);
}


while (fileInputStream2.available() > 0){
   int date2 = fileInputStream2.read();
    fileOutputStream.write(date2);
}

fileInputStream1.close();
fileInputStream2.close();
fileOutputStream.close();
    }


}
