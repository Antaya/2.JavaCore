package com.javarush.task.task19.task1916;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/* 
Отслеживаем изменения
*/

public class Solution {
    public static List<LineItem> lines = new ArrayList<LineItem>();

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String fileName1 = reader.readLine();
        String fileName2 = reader.readLine();
        reader.close();

        BufferedReader fr1 = new BufferedReader(new FileReader(fileName1));
        BufferedReader fr2 = new BufferedReader(new FileReader(fileName2));
        ArrayList<String> listForFile1 = new ArrayList<>();
        ArrayList<String> listForFile2 = new ArrayList<>();

        while (fr1.ready()) {
            String lineFile1 = fr1.readLine();
            listForFile1.add(lineFile1);
        }
        fr1.close();
        //    System.out.println(listForFile1);

        while (fr2.ready()) {
            String lineFile2 = fr2.readLine();
            listForFile2.add(lineFile2);
        }
        fr2.close();
        //     System.out.println(listForFile2);


        while (true) {
            if (listForFile1.size() == 0 || listForFile2.size() == 0) {
                if (listForFile1.size() != 0) {
                    lines.add(new LineItem(Type.REMOVED, listForFile1.get(0)));
                } else {
                    lines.add(new LineItem(Type.ADDED, listForFile2.get(0)));
                }
                break;
            } else if (listForFile1.get(0).equals(listForFile2.get(0))) {
                lines.add(new LineItem(Type.SAME, listForFile1.get(0)));
                listForFile1.remove(0);
                listForFile2.remove(0);
            } else if (!listForFile1.get(0).equals(listForFile2.get(0)) && listForFile1.get(1).equals(listForFile2.get(0))) {
                lines.add(new LineItem(Type.REMOVED, listForFile1.get(0)));
                listForFile1.remove(0);
            } else if (!listForFile1.get(0).equals(listForFile2.get(0)) && listForFile1.get(0).equals(listForFile2.get(1))) {
                lines.add(new LineItem(Type.ADDED, listForFile2.get(0)));
                listForFile2.remove(0);
            }
        }


        // for (LineItem item : lines){
        //     System.out.println(item.toString());
        //   }

    }


    public static enum Type {
        ADDED,        //добавлена новая строка
        REMOVED,      //удалена строка
        SAME          //без изменений
    }

    public static class LineItem {
        public Type type;
        public String line;

        public LineItem(Type type, String line) {
            this.type = type;
            this.line = line;
        }
        // public String toString(){
        //             return type + " " + line;
        //     }
    }
}
