package com.company;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner =new Scanner(System.in);
        Assembler assembler = new Assembler();
        BinaryToHexDecimal toHexDecimal = new BinaryToHexDecimal();
        int numberOfLines = Integer.parseInt(scanner.nextLine());
        String[] machineCodes = new String[numberOfLines];
        for(int i=0;i<machineCodes.length;++i)
            machineCodes[i] = toHexDecimal.getHexStr(assembler.commandVerify(scanner.nextLine()));
        System.out.println();
        print(machineCodes);
    }
    private static void print(String[] machineCodes) {
        for (String code : machineCodes)
            System.out.println(code);
    }
}
