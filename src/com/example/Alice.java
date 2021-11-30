package com.example;

import java.math.BigInteger;
import java.util.List;

import static com.example.Start.*;

public class Alice {

    //Открытый ключ от Боба
    public int[] publicKeyFromAlice = new int[2];

    //Открытый ключ от Алисы
    public int _e;
    public int _n;

    //Открытый ключ
    public int[] publicKey = new int[2];

    //Закрытый ключ
    private int[] privateKey = new int[2];

    public Alice(int e, int n, int d) {
        publicKey[0] = e;
        publicKey[1] = n;
        System.out.println("Алиса получает открытый ключ: {" + publicKey[0] + ", " + publicKey[1] + "}");
        privateKey[0] = d;
        privateKey[1] = n;
        System.out.println("Алиса получает закрытый ключ: {" + privateKey[0] + ", " + privateKey[1] + "}");
    }

    public int[] sendPublicKey() {
        System.out.println("Алиса отправляет свой открытый ключ Бобу: {" + publicKey[0] + ", " + publicKey[1] + "}");
        return publicKey;
    }

    public String decodeMessage(List<String> encodeMessage) {
        String result = "";
        for(int i=0; i<encodeMessage.size(); i++) {
            if(isNumeric(encodeMessage.get(i))) {
                Integer elementOfEncodeMessage = Integer.parseInt(encodeMessage.get(i));
                BigInteger degree = pow(elementOfEncodeMessage, privateKey[0]);
                int decodeNumber = degree.mod(BigInteger.valueOf(privateKey[1])).intValue();
                String decodeSymbol = String.valueOf(ALPH.charAt(decodeNumber));
                result = result + decodeSymbol;
            }
            else {
                result = result + encodeMessage.get(i);
            }
        }
        return result;
    }

}
