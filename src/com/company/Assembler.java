package com.company;


public class Assembler {

    private String ra = "11";
    private String s0 = "01";
    private String s1 = "10";
    private String zero = "00";

    String[] registers;

    StringBuilder machineCode = new StringBuilder();

    public String commandVerify(String command) {
        String[] cmd;
        cmd = command.split("\\s");
        switch (cmd[0]) {
            case "add":
                return Add(cmd[1]);
            case "sub":
                return Sub(cmd[1]);
            case "or":
                return Or(cmd[1]);
            case "and":
                return And(cmd[1]);
            case "slt":
                return Slt(cmd[1]);
            case "addi":
                return Addi(cmd[1]);
            case "lw":
                return Lw(cmd[1]);
            case "sw":
                return Sw(cmd[1]);
            case "beq":
                return Beq(cmd[1]);
            case "j":
                return J(cmd[1]);
            case "jr":
                return Jr(cmd[1]);
            case "jal":
                return Jal(cmd[1]);
            case "lli":
                return Lli(cmd[1]);
            default:
                break;
        }
        return "";
    }

    private String Add(String s) {
        machineCode = firstMode(s);
        machineCode.append("000000");
        return machineCode.toString();
    }

    private String Sub(String s) {
        machineCode = firstMode(s);
        machineCode.append("000010");
        return machineCode.toString();
    }

    private String Or(String s) {
        machineCode = firstMode(s);
        machineCode.append("000100");
        return machineCode.toString();
    }

    private String And(String s) {
        machineCode = firstMode(s);
        machineCode.append("000110");
        return machineCode.toString();
    }

    private String Slt(String s) {
        machineCode = firstMode(s);
        machineCode.append("001000");
        return machineCode.toString();
    }

    private String Addi(String s) {
        machineCode = thirdMode(s);
        machineCode.append("001011");
        return machineCode.toString();
    }

    private String Lw(String s) {
        machineCode = secondMode(s);
        machineCode.append("001101");
        return machineCode.toString();

    }

    private String Sw(String s) {
        machineCode = secondMode(s);
        machineCode.append("001111");
        return machineCode.toString();
    }

    private String Beq(String s) {
        machineCode = thirdMode(s);
        machineCode.append("010010");
        return machineCode.toString();
    }

    private String J(String s) {
        machineCode.append("00");
        machineCode.append(to_N_BitBinary(Integer.parseInt(s),8));
        machineCode.append("010101");
        return machineCode.toString();
    }

    private String Jr(String s) {
        machineCode.append("00000000");
        machineCode.append(registerToCode(s.replace("$","")));
        machineCode.append("010111");
        return machineCode.toString();
    }

    private String Jal(String s) {
        machineCode.append("00");
        machineCode.append(to_N_BitBinary(Integer.parseInt(s),8));
        machineCode.append("011001");
        return machineCode.toString();
    }

    private String Lli(String s) {
        machineCode.append("000000");
        machineCode.append(registerToCode(s.replace("$","")));
        machineCode.append("00");
        machineCode.append("011110");
        return machineCode.toString();
    }

    private String registerToCode(String register) {
        switch (register) {
            case "zero":
                return zero;
            case "ra":
                return ra;
            case "s0":
                return s0;
            case "s1":
                return s1;
            default:
                return "Not Valid!";
        }
    }

    //and or add sub slt use this method
    private StringBuilder firstMode(String s) {
        s = s.replace("$", "");
        registers = s.split("[,]");
        machineCode.append("0000");
        machineCode.append(registerToCode(registers[0]));
        machineCode.append(registerToCode(registers[2]));
        machineCode.append(registerToCode(registers[1]));
        return machineCode;
    }

    //lw sw
    private StringBuilder secondMode(String s) {
        s = s.replace("(", ",");
        s = s.replace("$", "");
        s = s.replace(")", "");
        registers = s.split(",");
        machineCode.append(to_N_BitBinary(Integer.parseInt(registers[1]),6));
        machineCode.append(registerToCode(registers[0]));
        machineCode.append(registerToCode(registers[2]));
        return machineCode;
    }

    //addi beq
    private StringBuilder thirdMode(String s) {
        s = s.replace("$", "");
        registers = s.split("[,]");
        machineCode.append(to_N_BitBinary(Integer.parseInt(registers[2]),6));
        machineCode.append(registerToCode(registers[0]));
        machineCode.append(registerToCode(registers[1]));
        return machineCode;
    }
    public String to_N_BitBinary(int number,int length){
        Boolean isNegetive = false;
        String s = Integer.toString(number,2);
        if (s.contains("-")){
            isNegetive = true;
            s = s.replace("-","");
        }
        StringBuilder binary = new StringBuilder(s);
        while (binary.length()<length){
           binary = binary.insert(0,"0");
        }
        if (binary.length()>length)
            return "out of range!";
        if (isNegetive){
            Mokamel2(binary);
        }
        System.out.println(binary.toString());
        return binary.toString();
    }

    private void Mokamel2(StringBuilder binary) {
        binary =binary.reverse();
        int index=10;
        boolean chech=true;
        for (int i = 0; i < binary.length(); ++i) {
            if (binary.charAt(i) == '1'&& chech) {
                index = i + 1;
                chech=false;
            }
            if (i >= index) {
                binary.replace(i, i+1 , revers(binary.charAt(i)));
            }
        }

    }

    private String revers(char charAt) {
        if (charAt == '0')
            return "1";
        else
            return "0";
    }
}
