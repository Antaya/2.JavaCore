package com.javarush.task.task18.task1808;

import java.io.*;

/* 
Разделение файла
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String fileName1 = reader.readLine();
        String fileName2 = reader.readLine();
        String fileName3 = reader.readLine();
        reader.close();
        FileInputStream fileInputStream1 = new FileInputStream(fileName1);

        FileOutputStream fileOutputStream2 = new FileOutputStream(fileName2);
        FileOutputStream fileOutputStream3 = new FileOutputStream(fileName3);

        byte[] buffer = new byte[1000];

        while (fileInputStream1.available() > 0) {
            int count = fileInputStream1.read(buffer);
            int halfBuffer = count / 2;
            if (count % 2 != 0) {
                halfBuffer += 1;
            }
                fileOutputStream2.write(buffer, 0, halfBuffer );
                fileOutputStream3.write(buffer, halfBuffer, count - halfBuffer);


          //  System.out.println(count);
        }

        fileInputStream1.close();
        fileOutputStream2.close();
        fileOutputStream3.close();



    }
}
