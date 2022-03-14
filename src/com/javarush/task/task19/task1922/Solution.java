package com.javarush.task.task19.task1922;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/* 
Ищем нужные строки
*/

public class Solution {
    public static List<String> words = new ArrayList<String>();

    static {
        words.add("файл");
        words.add("вид");
        words.add("В");
    }

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String fileName = reader.readLine();
        reader.close();

        BufferedReader fr = new BufferedReader(new FileReader(fileName));
        String line = "";

        while (fr.ready()) {
            line = fr.readLine();
            int count = 0;

            String[] str = line.split(" ");
            for (int i = 0; i < words.size(); i++) {
                count += Collections.frequency(Arrays.asList(str), words.get(i));
                }
            if (count == 2) {
                System.out.println(line);
            }
        }
            fr.close();
        }
    }


