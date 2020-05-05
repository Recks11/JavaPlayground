package com.rexijie.condition;

public class ConditionalStatements {
    // JAVA 8
    static void switchNum(int num) {
        switch (num) {
            case 1:
                System.out.println(1);
            case 0:
                System.out.println(0);
            case 2:
                System.out.println(2);
                break;
            case 3:
                System.out.println(3);
            default:
                System.out.println(4);
        }
    }
    public static void main(String[] args) {
        switchNum(0);
    }
}

class StringOps  {

    public static void main(String[] args) {
        String  s =  new StringBuilder()
                .append("Olalade")
                .append(" Eladayo")
                .toString();
        System.out.println(s);

        char[] y = new char[] {'r','w','d'};

        String ys =  new String(y);
        System.out.println(ys);
    }
}
