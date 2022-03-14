package com.javarush.task.task15.task1530;

/* 
Template pattern
*/

public class Solution {
    public static void main(String[] args) {
        DrinkMaker drinkMaker = new TeaMaker();
        DrinkMaker drinkMaker1 = new LatteMaker();
        drinkMaker.makeDrink();
        drinkMaker1.makeDrink();
    }
}
