package com.example;

import java.util.ArrayList;
import java.util.List;

import static com.example.PrimeNumber.generatePrimeNumber;
import static com.example.Start.ALPH;

public class SecretKey {

    //Проверяет ялвяются ли два числа взаимнопростыми
    public static boolean isCoprime(int a, int b) {
        if(a==0) {
            return false;
        }

        while(b!=0) {
            if(a>b) {
                a = a - b;
            }
            else {
                b = b - a;
            }
        }

        if(a!=1) {
            return false;
        }
        return true;
    }

    //Выводит список секретных ключей (4 числа)
    //Первые два числа - открытый ключ
    //Последние два числа - закрытый ключ
    public static List<Integer> getSecretKeys() {

        //Выбирам два различных случайных простых числа p и q заданного размера
        int p;
        int q;
        do {
            p = generatePrimeNumber(20);
            q = generatePrimeNumber(20);
        }
        while(p==q || p*q<ALPH.length());
        System.out.println("p = " + p);
        System.out.println("q = " + q);

        //Вычисляем их произведение n=p⋅q
        int n = p * q;
        System.out.println("n = " + n);

        //Вычисляем значение функции Эйлера от числа n:
        int f = (p - 1) * (q - 1);
        System.out.println("f = " + f);

        //Выбираем целое число e (1<e<f), взаимно простое со значением функции f.
        //В качестве e возьмём просто число
        int e;
        do {
            e = generatePrimeNumber(f);
        }
        while(!isCoprime(f, e));
        System.out.println("e = " + e);

        //Вычисляем число d
        int d;
        do {
            d = (int) (1 + Math.random() * 1000);
        }
        while( (d * e) % f != 1 );
        System.out.println("d = " + d);

        List<Integer> secretKeys = new ArrayList<>();
        secretKeys.add(e);
        secretKeys.add(n);
        secretKeys.add(d);
        secretKeys.add(n);

        return secretKeys;
    }
}
