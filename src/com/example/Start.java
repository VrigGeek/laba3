package com.example;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

import static com.example.SecretKey.getSecretKeys;

public class Start {

    public static final String ALPH = "абвгдеёжзийклмнопрстуфхцчшщъыьэюя";

    public static boolean isNumeric(String str) {
        return str.matches("-?\\d+(\\.\\d+)?");  //match a number with optional '-' and decimal.
    }

    public static BigInteger pow(int value, int powValue) {
        BigInteger result = BigInteger.valueOf(1);
        for (int i=1; i<=powValue; i++) {
            result = result.multiply(BigInteger.valueOf(value));
        }
        return result;
    }

    public static void main(String[] args) {
        //Выдача ключей Алисе
        List<Integer> secretKeysForAlice = new ArrayList<>();
        secretKeysForAlice.addAll(getSecretKeys());
        Alice alice = new Alice(secretKeysForAlice.get(0), secretKeysForAlice.get(1), secretKeysForAlice.get(2));

        //Алиса отправляет свой публичный ключ Бобу
        Bob bob = new Bob();
        bob.publicKeyFromAlice = alice.sendPublicKey();

        //Боб отправляет сообщение
        String message = "привет алиса!";
        System.out.println("\nИсходное сообщение: " + message);
        System.out.println("Алиса расшифровала сообщение: " + alice.decodeMessage(bob.sendMessage(message)));
    }
}
