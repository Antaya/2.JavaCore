package com.javarush.task.task15.task1529;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/* 
Осваивание статического блока
*/

public class Solution {

    public static CanFly result = null;
    public static void main(String[] args) {

    }

    static {
      reset();
        System.out.println(result);//add your code here - добавьте код тут
    }



    public static void reset() {
        //add your code here - добавьте код тут
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        try {
            String typeOfAirTransport = reader.readLine();
            if (typeOfAirTransport.equals("helicopter")){
                Solution.result = new Helicopter();
            }else if(typeOfAirTransport.equals("plane")){
                Plane plane = new Plane(20);
                Solution.result = plane;
            } else System.out.println("введите значения \"helicopter\" или \"plane\"");
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }



    }
}
