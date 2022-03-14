package com.javarush.task.task18.task1826;

import java.io.FileInputStream;
import java.io.FileOutputStream;


/* 
Шифровка
*/

public class Solution {

    public static void main(String[] args) throws Exception {


        FileInputStream fileInputStream = new FileInputStream(args[1]);
        FileOutputStream fileOutputStream = new FileOutputStream(args[2]);

           switch (args[0]) {
            case "-e":
                //  for (int i = 0; i < args.length; i++) {
                //     System.out.println(args[i]);
                // }

                while (fileInputStream.available() > 0) {
                    fileOutputStream.write(fileInputStream.read() + 32);
                }


                 break;

            case "-d":
                // for (int i = 0; i < args.length; i++) {
                //   System.out.println(args[i]);
                // }

                while (fileInputStream.available() > 0) {
                    fileOutputStream.write(fileInputStream.read() - 32);
                }


                break;


        }
        fileInputStream.close();
        fileOutputStream.close();


    }
}



