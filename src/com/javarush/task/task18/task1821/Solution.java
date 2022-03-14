package com.javarush.task.task18.task1821;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.TreeMap;

/* 
Встречаемость символов
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        if (args.length == 0) {
            return;
        }
        FileInputStream fileInputStream = new FileInputStream(args[0]);

        Map<Character, Integer> chars = new TreeMap<>();
        while (fileInputStream.available() > 0) {
            char date = (char) fileInputStream.read();
            if (!chars.containsKey(date)) {
                chars.put(date, 1);

            } else chars.put(date, chars.get(date) + 1);
        }
        fileInputStream.close();

        Iterator<Map.Entry<Character, Integer>> iterator = chars.entrySet().iterator();

        while (iterator.hasNext()) {
            //получение «пары» элементов
            Map.Entry<Character, Integer> pair = iterator.next();
            Character key = pair.getKey();            //ключ
            Integer value = pair.getValue();        //значение
            System.out.println(key + " " + value);
        }
    }
}
