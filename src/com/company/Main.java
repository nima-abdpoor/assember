package com.company;

public class Main {

    public static void main(String[] args) {
        Assembler assembler = new Assembler();
        System.out.println(assembler.commandVerify("addi $s0,$zero,10"));
        System.out.println(assembler.commandVerify("addi $s1,$zero,$20"));
        System.out.println(assembler.commandVerify("add $ra,$s0,$s1"));
        System.out.println(assembler.commandVerify("sw $ra,0($zero)"));
        System.out.println(assembler.commandVerify("sub $ra,$s0,$s1"));
        System.out.println(assembler.commandVerify("sw $ra,2($zero)"));
        System.out.println(assembler.commandVerify("and $ra,$s0,$s1"));
        System.out.println(assembler.commandVerify("sw $ra,4($zero)"));
        System.out.println(assembler.commandVerify("or $ra,$s0,$s1"));
        System.out.println(assembler.commandVerify("sw $ra,6($zero)"));
        System.out.println(assembler.commandVerify("beq $s0,$s1,-22"));
        System.out.println(assembler.commandVerify("addi $s0,$zero,20"));
        System.out.println(assembler.commandVerify("beq $s0,$s1,6"));
        System.out.println(assembler.commandVerify("sw $zero,0($zero)"));
        System.out.println(assembler.commandVerify("sw $zero,0($zero)"));
        System.out.println(assembler.commandVerify("sw $zero,0($zero)"));
        System.out.println(assembler.commandVerify("j 0"));
    }

}
