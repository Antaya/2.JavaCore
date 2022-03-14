package com.javarush.task.task18.task1827;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

/* 
Прайсы
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        if (args.length == 0)
            return;

        if (args[0].equals("-c")) {
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

            String fileName = reader.readLine();
            reader.close();

            int index = getIndex(fileName);

            String productName = args[1];
            if (productName.length() > 30) {
                productName = productName.substring(0, 30).trim();
            }
            String price = args[2];
            if (price.length() > 8) {
                price = price.substring(30, 38).trim();
            }
            String quantity = args[3];
            if (quantity.length() > 4) {
                quantity = quantity.substring(38, 42).trim();
            }


            String formatStr = String.format("%-8s%-30s%-8s%-4s%n", index, productName, price, quantity);
            // System.out.print(formatStr);

            addStringToFile(fileName, formatStr);


        }
    }

    public static int getIndex(String fileName) {
        ArrayList<String> fileStrings = readFile(fileName);
        fileStrings.removeIf(String::isEmpty);
        int maxFileIndex = 0;
        for (String str : fileStrings) {

            int fileIndex = Integer.parseInt(str.substring(0, 8).trim());

            if (maxFileIndex < fileIndex)
                maxFileIndex = fileIndex;

        }
        maxFileIndex++;
        return maxFileIndex;
    }

    public static ArrayList<String> readFile(String fileName) {
        ArrayList<String> fileStrings = new ArrayList<>();
        try {
            FileInputStream fileInputStream = new FileInputStream(fileName);
            Scanner scanner = new Scanner(fileInputStream);

            while (scanner.hasNext()) {
                fileStrings.add(scanner.nextLine());

            }
            fileInputStream.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return fileStrings;
    }

    public static void addStringToFile(String fileName, String formatStr) {
        // блок добавляет строку в конец файла (работает, но валидатор не принимает)

        //   try {
        //       FileOutputStream fileOutputStream = new FileOutputStream(fileName, true);
        //       fileOutputStream.write(formatStr.getBytes());
        //       fileOutputStream.close();
        //   } catch (FileNotFoundException e) {
        //       e.printStackTrace();
        //   } catch (IOException e) {
        //      e.printStackTrace();


        // блок для валидатора

        try (FileWriter fileWriter = new FileWriter(fileName, true)) {
            fileWriter.write("\n" + formatStr);
        } catch (IOException e) {
            e.printStackTrace();
        }


    }


}


