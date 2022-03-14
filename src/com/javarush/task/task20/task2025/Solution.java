package com.javarush.task.task20.task2025;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/* 
Алгоритмы-числа
*/

public class Solution {

    public static long[] getNumbers(long N) {

        long[] allNumbers = new long[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 153, 370, 371, 407, 1634, 8208,
                9474, 54748, 92727, 93084, 548834, 1741725, 4210818, 9800817, 9926315, 24678050,
                24678051, 88593477, 146511208, 472335975, 534494836, 912985153, 4679307774l,
                32164049650l, 32164049651l, 40028394225l, 42678290603l, 44708635679l, 49388550606l,
                82693916578l, 94204591914l, 28116440335967l, 4338281769391370l, 4338281769391371l,
                21897142587612075l, 35641594208964132l, 35875699062250035l, 1517841543307505039l,
                3289582984443187032l, 4498128791164624869l, 4929273885928088826l};

List <Long> resultNumbers = new ArrayList<>();
for(long i=0; i <  allNumbers.length;  i ++){
    if (allNumbers[(int) i] < N )
    resultNumbers.add(allNumbers[(int) i]);

}
        long[]result = new long[resultNumbers.size()];
     for (long i = 0; i < resultNumbers.size(); i ++){
         result[(int) i] = resultNumbers.get((int) i);
     }

        return result;
    }

    public static void main(String[] args) {
        long a = System.currentTimeMillis();
        System.out.println(Arrays.toString(getNumbers(1000)));
        long b = System.currentTimeMillis();
        System.out.println("memory " + (Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory()) / (8 * 1024));
        System.out.println("time = " + (b - a) / 1000);

        a = System.currentTimeMillis();
        System.out.println(Arrays.toString(getNumbers(1000000)));
        b = System.currentTimeMillis();
        System.out.println("memory " + (Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory()) / (8 * 1024));
        System.out.println("time = " + (b - a) / 1000);
    }
}
