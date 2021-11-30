package com.example;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

import static com.example.Start.*;

public class Bob {

    //Открытый ключ от Алисы
    public int[] publicKeyFromAlice = new int[2];

    public List<String> sendMessage(String str) {

        //Пребразуем сообщение в массив целых чисел
        //Где каждое число это позиция буквы в русской алфавите
        //а=0, б=1, в=2, г=3 и т.д.
        List<String> listOfSymbols = new ArrayList<>();
        for(int i=0; i<str.length(); i++) {
            if(ALPH.indexOf(str.charAt(i))!=-1) {
                listOfSymbols.add(String.valueOf(ALPH.indexOf(str.charAt(i))));
            }
            else {
                listOfSymbols.add(String.valueOf(str.charAt(i)));
            }
        }
        System.out.println("Символы исходного сообщения в алфавитном порядке: " + listOfSymbols);

        List<String> messageEncode = new ArrayList<>();
        for(int i=0; i<listOfSymbols.size(); i++) {
            if(isNumeric(listOfSymbols.get(i))) {
                BigInteger degree = pow(Integer.valueOf(listOfSymbols.get(i)), publicKeyFromAlice[0]);
                messageEncode.add(String.valueOf(degree.mod(BigInteger.valueOf(publicKeyFromAlice[1]))));
            }
            else {
                messageEncode.add(String.valueOf(listOfSymbols.get(i)));
            }
        }
        System.out.println("Боб зашифровал сообщение и  отправил Алисе: " + messageEncode);
        return messageEncode;
    }
}
