package com.javarush.task.task18.task1804;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.*;

/* 
Самые редкие байты
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        FileInputStream fileInputStream = new FileInputStream(reader.readLine());
        reader.close();

        HashMap<Integer, Integer> bytes = new HashMap<>();
        int counter = 0;
        String result = "";

        while (fileInputStream.available() > 0) {
            int date = fileInputStream.read();
            if (!bytes.containsKey(date)) {
                counter = 0;
                bytes.put(date, counter);
            } else bytes.put(date, bytes.get(date) + 1);

        }
        fileInputStream.close();
        //System.out.println(bytes);

        ArrayList<Integer> values = new ArrayList<>(bytes.values());
       // System.out.println(values);

        Set<Map.Entry<Integer, Integer>> entrySet = bytes.entrySet();
        for (Map.Entry<Integer, Integer> pair : entrySet){
            if(Collections.min(values) == pair.getValue()){
                result += pair.getKey() + " ";
            }
        }

        System.out.println(result);


    }
}

