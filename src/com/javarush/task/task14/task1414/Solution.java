package com.javarush.task.task14.task1414;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/* 
MovieFactory
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        //ввести с консоли несколько ключей (строк), пункт 7
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
  /*
8 Создать переменную movie класса Movie и для каждой введенной строки(ключа):
8.1 получить объект используя MovieFactory.getMovie и присвоить его переменной movie
8.2 вывести на экран movie.getClass().getSimpleName()
        */
        String key;

            while ((key = reader.readLine()) != null) {
                Movie movie = MovieFactory.getMovie(key);
                if (movie == null) {
                    return;
                }
                System.out.println(movie.getClass().getSimpleName());
            }
        //} catch (NullPointerException e) {
          //  System.out.println("неверный ключ");
        //}

    }

    static class MovieFactory {

        static Movie getMovie(String key) {

            Movie movie = null;


            //создание объекта SoapOpera (мыльная опера) для ключа "soapOpera"  и т.д.
                    switch (key) {
                case "soapOpera":
                    movie = new SoapOpera();

                    break;
                case "cartoon":
                    movie = new Cartoon();

                    break;
                case "thriller":
                    movie = new Thriller();

                    break;
                default:
                    break;

            }

            //напишите тут ваш код, пункты 5,6


            return movie;
        }
    }

    static abstract class Movie {
    }

    static class SoapOpera extends Movie {
    }

    //Напишите тут ваши классы, пункт 3
    static class Cartoon extends Movie {
    }

    static class Thriller extends Movie {
    }
}
