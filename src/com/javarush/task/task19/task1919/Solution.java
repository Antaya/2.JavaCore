package com.javarush.task.task19.task1919;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

/* 
Считаем зарплаты
В метод main первым параметром приходит имя файла.
В этом файле каждая строка имеет следующий вид:
имя значение
где [имя] - String, [значение] - double. [имя] и [значение] разделены пробелом.

Для каждого имени посчитать сумму всех его значений.
Все данные вывести в консоль, предварительно отсортировав в возрастающем порядке по имени.
Закрыть потоки.
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader fr = new BufferedReader(new FileReader(args[0])); // считать имя файла из параметров

        String line = "";
       Map<String, Double> map = new TreeMap<>(); // TreeMap для данных из файла
        while (fr.ready()){
            line = fr.readLine();
            String[]str = line.split(" "); // разбить строку по пробелу (имя, значение)
            if (!map.containsKey(str[0])){ // если такого имени нет среди ключей в TreeMap - добавляем key - имя, value - значение (парсим String)
                map.put(str[0], Double.parseDouble(str[1]));
                }else
                    map.put(str[0], map.get(str[0]) + Double.parseDouble(str[1])); // если ключ-имя уже есть - перезаписываем ключ и прибавляем к старому value новое значение.
        }
        fr.close(); //закрываем поток


        for (Map.Entry<String, Double> pair : map.entrySet())
        {
            String key = pair.getKey();                      //ключ
           Double value = pair.getValue();                  //значение
            System.out.println(key + " " + value); // вывод в консоль
        }

    }

}
