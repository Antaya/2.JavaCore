package com.javarush.task.task13.task1326;

import java.io.*;
import java.util.*;

/* 
Сортировка четных чисел из файла
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        // напишите тут ваш код
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String fileName = reader.readLine();

        List<Integer> numbers = new ArrayList<>();
        BufferedReader fileReader = new BufferedReader(new InputStreamReader(new FileInputStream(fileName)));
        String line;
        while ((line = fileReader.readLine()) != null) {

            if (line.equals("")) {
                continue;
            }

            numbers.add(Integer.parseInt(line));

        }
        Collections.sort(numbers);
        for (Integer in : numbers) {
            if (in % 2 == 0)

                System.out.println(in);
        }

        fileReader.close();

    }

}

