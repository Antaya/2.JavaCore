package com.javarush.task.task20.task2003;

import java.io.*;
import java.util.*;

/* 
Знакомство с properties
*/

public class Solution {

    public static Map<String, String> runtimeStorage = new HashMap<>();

    public static void save(OutputStream outputStream) throws Exception {
        //напишите тут ваш код
        Properties propsSave = new Properties();

        Set mapKeys = runtimeStorage.keySet();
        for (Object s : mapKeys) {
            propsSave.setProperty((String) s, runtimeStorage.get((String) s));
        }
        propsSave.store(outputStream, "save");

        outputStream.close();


    }

    public static void load(InputStream inputStream) throws IOException {
        //напишите тут ваш код
        Properties propsLoad = new Properties();
        propsLoad.load(inputStream);
        Set keys = propsLoad.keySet();
        for (Object key : keys) {
            runtimeStorage.put((String) key, propsLoad.getProperty((String) key));
        }

        inputStream.close();

    }


    public static void main(String[] args) {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
             FileInputStream fos = new FileInputStream(reader.readLine())) {
            load(fos);
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println(runtimeStorage);
    }
}
