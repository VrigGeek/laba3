package com.example;

import java.util.ArrayList;
import java.util.List;

public class PrimeNumber {

    //Возвращает массив простых чисел до n
    private static List<Integer> getArrayPrimeNumbers(int n) {
        boolean[] arr = new boolean[n+1];
        List<Integer> integerList = new ArrayList<>();
        for(int p=2; p*p<=n; p++) {
            if(!arr[p]) {
                for(int q=p*p; q<=n; q++) {
                    if(q%p == 0) {
                        arr[q] = true;
                    }
                }
            }

        }

        for(int i=2; i<arr.length; i++) {
            if(!arr[i]) {
                integerList.add(i);
            }
        }
        return integerList;
    }

    //Генерирует случайное простое число
    public static Integer generatePrimeNumber(int n) {
        List<Integer> integerList = new ArrayList<>(getArrayPrimeNumbers(n));
        Integer sizeList = integerList.size();
        Integer num = (int) (Math.random() * sizeList);
        return integerList.get(num);
    }

}