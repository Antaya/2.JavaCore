package com.javarush.task.task20.task2027;

import java.util.ArrayList;
import java.util.List;

/*
Кроссворд
*/

public class Solution {
    public static void main(String[] args) {
        int[][] crossword = new int[][]{
                {'f', 'd', 'e', 'r', 'l', 'k'},
                {'u', 's', 'a', 'm', 'e', 'o'},
                {'l', 'n', 'g', 'r', 'o', 'v'},
                {'m', 'l', 'p', 'r', 'r', 'h'},
                {'p', 'o', 'e', 'e', 'j', 'j'}
        };
        detectAllWords(crossword, "home", "same");
        /*
Ожидаемый результат
home - (5, 3) - (2, 0)
same - (1, 1) - (4, 1)
         */


    }

    public static List<Word> detectAllWords(int[][] crossword, String... words) {
        List<Word> foundWords = new ArrayList<>();

        for (String word : words) {

            for (int i = 0; i < crossword.length; i++) {  //идём по строкам
                for (int j = 0; j < crossword[i].length; j++) {//идём по столбцам

                    if (word.length() == 1 && word.charAt(0) == crossword[i][j]) { // слово из одной буквы
                        Word w = new Word(word);
                        w.setStartPoint(i, j);
                        w.setEndPoint(i, j);
                        foundWords.add(w);
                    } else if (word.charAt(0) == crossword[i][j]) { //совпадение первой буквы, далее проверка по всем направлениям

                        foundWords.add(checkToTheRight(crossword, word, i, j));
                        foundWords.add(checkToTheLeft(crossword, word, i, j));
                        foundWords.add(checkVerticalDown(crossword, word, i, j));
                        foundWords.add(checkVerticalUp(crossword, word, i, j));
                        foundWords.add(checkToDiagonalFromLeftToRightFromTopToBottom(crossword, word, i, j));
                        foundWords.add(checkToDiagonalFromRightToLeftFromBottomToTop(crossword, word, i, j));
                        foundWords.add(checkToDiagonalFromRightToLeftFromTopToBottom(crossword, word, i, j));
                        foundWords.add(checkToDiagonalFromLeftToRightFromBottomToTop(crossword, word, i, j));
                    }

                }
            }
        }
List <Word> result = new ArrayList<>();
        for (Word foundWord : foundWords) { // вывод списка всех найденных слов
            if (foundWord != null)
            result.add(foundWord);
        }

        return result;
    }


    public static Word checkToTheRight(int[][] crossword, String word, int startX, int startY) {
        int x = startX;
        int y = startY + 1;
        for (int i = 1; i < word.length(); i++) {
            if (y >= crossword[0].length) return null;
            if ((char) crossword[x][y] != word.charAt(i))
                return null;
            if (word.charAt(i) == crossword[x][y])
                y++;
        }

        Word w = new Word(word);
        w.setStartPoint(startY, startX);
        w.setEndPoint(startY + word.length() - 1, startX);

        return w;
    }

    public static Word checkToTheLeft(int[][] crossword, String word, int startX, int startY) {
        int x = startX;
        int y = startY - 1;
        for (int i = 1; i < word.length(); i++) {
            if (x < 0 || y < 0)
                return null;
            if ((char) crossword[x][y] != word.charAt(i))
                return null;
            if (word.charAt(i) == crossword[x][y])
                y--;
        }

        Word w = new Word(word);
        w.setStartPoint(startY, startX);
        w.setEndPoint(startY - (word.length() - 1), startX);

        return w;
    }

    static Word checkVerticalDown(int[][] crossword, String word, int startX, int startY) {
        int x = startX + 1;
        int y = startY;
        for (int i = 1; i < word.length(); i++) {
            if (x >= crossword.length) return null;
            if ((char) crossword[x][y] != word.charAt(i))
                return null;
            if (word.charAt(i) == crossword[x][y])
                x++;
        }

        Word w = new Word(word);
        w.setStartPoint(startY, startX);
        w.setEndPoint(startY, startX + (word.length() - 1));


        return w;
    }

        static Word checkVerticalUp(int[][] crossword, String word, int startX, int startY) {
        int x = startX - 1;
        int y = startY;
        for (int i = 1; i < word.length(); i++) {
            if (x < 0) return null;
            if ((char) crossword[x][y] != word.charAt(i))
                return null;
            if (word.charAt(i) == crossword[x][y])
                x--;
        }

        Word w = new Word(word);
        w.setStartPoint(startY, startX);
        w.setEndPoint(startY, startX - (word.length() - 1));

        return w;
    }

    public static Word checkToDiagonalFromLeftToRightFromTopToBottom(int[][] crossword, String word, int startX, int startY) {
        int x = startX + 1;
        int y = startY + 1;
        for (int i = 1; i < word.length(); i++) {
            if (x >= crossword.length || y >= crossword[0].length) return null;

            if ((char) crossword[x][y] != word.charAt(i))
                return null;
            if (word.charAt(i) == crossword[x][y])
                x++;
            y++;
        }

        Word w = new Word(word);
        w.setStartPoint(startY, startX);
        w.setEndPoint(startY + (word.length() - 1), startX + (word.length() - 1));

        return w;
    }

    public static Word checkToDiagonalFromRightToLeftFromBottomToTop(int[][] crossword, String word, int startX, int startY) {
        int x = startX - 1;
        int y = startY - 1;
        for (int i = 1; i < word.length(); i++) {
            if(x <0 || y < 0) return null;
            if ((char) crossword[x][y] != word.charAt(i))
                return null;
            if (word.charAt(i) == crossword[x][y])
                x--;
                y--;
        }

        Word w = new Word(word);
        w.setStartPoint(startY, startX);
        w.setEndPoint(startY - (word.length() - 1), startX - (word.length() - 1));

        return w;
    }


    public static Word checkToDiagonalFromRightToLeftFromTopToBottom(int[][] crossword, String word, int startX, int startY) {
        int x = startX + 1;
        int y = startY - 1;
        for (int i = 1; i < word.length(); i++) {
            if (x >= crossword.length || y < 0) return null;

            if ((char) crossword[x][y] != word.charAt(i))
                return null;
            if (word.charAt(i) == crossword[x][y])
                x++;
            y--;

        }

        Word w = new Word(word);
        w.setStartPoint(startY, startX);
        w.setEndPoint(startY - (word.length() - 1), startX + (word.length() - 1));

        return w;
    }

    public static Word checkToDiagonalFromLeftToRightFromBottomToTop(int[][] crossword, String word, int startX, int startY) {
        int x = startX - 1;
        int y = startY + 1;
        for (int i = 1; i < word.length(); i++) {
            if(x < 0 || y >= crossword[0].length) return null;
            if ((char) crossword[x][y] != word.charAt(i))
                return null;
            if (word.charAt(i) == crossword[x][y])
                x--;
            y++;

        }

        Word w = new Word(word);
        w.setStartPoint(startY, startX);
        w.setEndPoint(startY + (word.length() - 1), startX - (word.length() - 1));

        return w;
    }


    public static class Word {
        private String text;
        private int startX;
        private int startY;
        private int endX;
        private int endY;

        public Word(String text) {
            this.text = text;
        }

        public void setStartPoint(int i, int j) {
            startX = i;
            startY = j;
        }

        public void setEndPoint(int i, int j) {
            endX = i;
            endY = j;
        }

        @Override
        public String toString() {
            return String.format("%s - (%d, %d) - (%d, %d)", text, startX, startY, endX, endY);
        }
    }
}
