package com.company;

public class Main {

    public static void main(String[] args) {
        Assembler assembler = new Assembler();
        BinaryToHexDecimal toHexDecimal = new BinaryToHexDecimal();
        System.out.println(toHexDecimal.getHexStr(assembler.commandVerify("addi $s0,$zero,10")));
    }
}
