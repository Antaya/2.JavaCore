package com.javarush.task.task14.task1417;

import java.util.ArrayList;
import java.util.List;

/* 
Валюты
*/

public class Solution {
    public static void main(String[] args) {
        Person ivan = new Person("Иван");
        for (Money money : ivan.getAllMoney()) {
            System.out.println(ivan.name + " имеет заначку в размере " + money.getAmount() + " " + money.getCurrencyName());
        }
    }

    static class Person {
        public String name;

        Person(String name) {
            this.name = name;
            this.allMoney = new ArrayList<Money>();

        }

        private List<Money> allMoney;

        public List<Money> getAllMoney() {
            Money money = new USD(2.0);
            Money money1 = new Ruble(15.0);
            Money money2 = new Hryvnia(4.0);
            allMoney.add(money);
            allMoney.add(money1);
            allMoney.add(money2);
            return allMoney;
        }
    }
}
