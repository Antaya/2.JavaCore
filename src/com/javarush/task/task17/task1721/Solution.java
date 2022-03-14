package com.javarush.task.task17.task1721;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/* 
Транзакционность
*/

public class Solution {
    public static List<String> allLines = new ArrayList<String>();
    public static List<String> forRemoveLines = new ArrayList<String>();

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        FileInputStream fileName1 = new FileInputStream(reader.readLine());
        FileInputStream fileName2 = new FileInputStream(reader.readLine());
        reader.close();
        Scanner scanner1 = new Scanner(fileName1);
        while (scanner1.hasNext()) {
            allLines.add(scanner1.nextLine());
        }
        scanner1.close();

        Scanner scanner2 = new Scanner(fileName2);


        while (scanner2.hasNext()) {
            forRemoveLines.add(scanner2.nextLine());
        }
        scanner2.close();
       // System.out.println(allLines);
        //System.out.println(forRemoveLines);

      new  Solution().joinData();
        //System.out.println(allLines);
        //System.out.println(forRemoveLines);
    }

    public  void joinData() throws CorruptedDataException {

        if (allLines.containsAll(forRemoveLines))
            allLines.removeAll(forRemoveLines);
       else {
            allLines.clear();
            throw new CorruptedDataException();
        }
    }
}
