package com.example.littlebigendian;

import java.math.BigInteger;

public class Library {
    String hexToLittleEndian(MainActivity.Vector inputVector) {
        long ret = 0;
        String hexLittleEndian = "";
        if (inputVector.hexValue.length() % 2 == 0) {
            for (int i = inputVector.hexValue.length() - 2; i >= 0; i -= 2) {
                hexLittleEndian += inputVector.hexValue.substring(i, i + 2);
            }
            try {
                ret = Long.parseLong(hexLittleEndian, 16);
            } catch (Exception ex ){
                System.out.println("---> parseLong ex: " + ex.toString());
            }
        }

        return String.format("%d", ret);
    }

    String hexToBigEndian(MainActivity.Vector inputVector) {
        long ret = 0;
        if (inputVector.hexValue.length() % 2 == 0) {
            try {
                ret = Long.parseLong(inputVector.hexValue, 32);
            } catch (Exception ex ){
                System.out.println("---> parseLong ex: " + ex.toString());
            }
        }

        return String.format("%d", ret);
    }

    String littleEndianToHex(MainActivity.Vector inputVector) {

        BigInteger big = new BigInteger(inputVector.littleEndian);
        return big.toString(16);
    }

    String bigEndianToHex(MainActivity.Vector inputVector ) {
        BigInteger big = new BigInteger(inputVector.bigEndian);
        String result = big.toString(16);
        return result;
    }

}
