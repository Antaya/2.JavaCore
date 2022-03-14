package com.javarush.task.task15.task1516;

/* 
Значения по умолчанию
*/

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public int intVar = 0;
    public  double doubleVar = 0.0;
    public  Double DoubleVar = 0.0;
    public boolean booleanVar = false;
    public  Object ObjectVar = null;
    public  Exception ExceptionVar = null;
    public  String StringVar = null;


        public void printVar() {

        System.out.println(intVar);
        System.out.println(doubleVar);
        System.out.println(DoubleVar);
        System.out.println(booleanVar);
        System.out.println(ObjectVar);
        System.out.println(ExceptionVar);
        System.out.println(StringVar);
    }



    public static void main(String[] args) {

     Solution solution = new Solution();
solution.printVar();



    }
}
