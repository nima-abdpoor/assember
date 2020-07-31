package com.company;

public class BinaryToHexDecimal {
    String hexStr;
    int decimal;

    String getHexStr(String binary){
        decimal = Integer.parseInt(binary,2);
        hexStr = Integer.toString(decimal,16);
        return hexStr;
    }

}
