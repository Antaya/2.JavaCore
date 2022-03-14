package com.javarush.task.task18.task1828;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/* 
Прайсы 2
*/

public class Solution {
    public static void main(String[] args) throws IOException {

        if (args.length == 0) return;

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String fileName = reader.readLine();
        reader.close();

        switch (args[0]) {
            case "-u":
                String id = args[1];
                if (id.length() > 8) {
                    id = id.substring(0, 8).trim();
                }

                String productName = args[2];
                if (productName.length() > 30) {
                    productName = productName.substring(8, 38).trim();
                }
                String price = args[3];
                if (price.length() > 8) {
                    price = price.substring(38, 46).trim();
                }
                String quantity = args[4];
                if (quantity.length() > 4) {
                    quantity = quantity.substring(46, 50).trim();
                }

                String formatStr = String.format("%-8s%-30s%-8s%-4s", id, productName, price, quantity);

                update(fileName, formatStr);

                return;
            case "-d":
                id = args[1];
                if (id.length() > 8) {
                    id = id.substring(0, 8).trim();
                }

                 deleteStringById(fileName, id);
                return;
        }

    }





    public static void update(String fileName, String formatStr) throws IOException {

        ArrayList<String> fileStrings = readFile(fileName);
        fileStrings.removeIf(String::isEmpty);
        String id = formatStr.substring(0, 8).trim();
        int index = 0;
        for (String s : fileStrings) {
            if (id.equals(s.substring(0, 8).trim())) {
                index = fileStrings.indexOf(s);
            }

        }
        fileStrings.set(index, formatStr);
       addToFile(fileName, fileStrings);

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

    public static void deleteStringById(String fileName, String id) throws IOException {
        ArrayList<String> fileStrings = readFile(fileName);
        fileStrings.removeIf(String::isEmpty);
        int index = 0;
        for (String s : fileStrings) {
            if (id.equals(s.substring(0, 8).trim())) {
                index = fileStrings.indexOf(s);
            }

        }
        fileStrings.remove(index);
       addToFile(fileName, fileStrings);
    }

    public static void addToFile(String fileName, ArrayList<String> list) throws IOException {
        try (FileWriter fileWriter = new FileWriter(fileName)) {
            for (String s : list) {
                fileWriter.write(s);
                fileWriter.write("\n");
            }

        }

    }
}
