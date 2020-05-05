package com.rexijie.interviews;

import java.util.Arrays;
import java.util.HashSet;

//class Palindrome {
//
//    public static boolean isPalindrome(String word) {
//        String safeWord = word.toLowerCase();
//        String[] split = safeWord.split("");
//        String[] reverse = new String[split.length];
//
//        for (int i = split.length - 1; i >= 0; i--) {
//            reverse[(split.length - 1) - i] = split[i];
//        }
//
//        return Arrays.equals(split, reverse);
//    }
//
//    public static void main(String[] args) {
//        System.out.println(Palindrome.isPalindrome("Deleveled"));
//    }
//}
class Palindrome {
    public static boolean isPalindrome(String word) {
        String[] wordArray = word.toLowerCase().split("");
//        String[] tempArray = new String[wordArray.length];
        String s = "";

        for (int i=0 ; i <= wordArray.length-1 ; i++)  {
//            tempArray[i] = wordArray[(wordArray.length-1) - i];
            s = s + wordArray[(wordArray.length-1) - i];
        }

        return s.equals(word.toLowerCase());
    }

    public static void main(String[] args) {
        System.out.println(Palindrome.isPalindrome("Delevelsed"));
    }
}
public class Java8Test {
    public static void main(String[] args) {
    }
}

class MergeNames {

    private static String[] uniqueNames(String[] names1, String[] names2) {
        HashSet<String> hashedSet = new HashSet<>();

        hashedSet.addAll(Arrays.asList(names1));
        hashedSet.addAll(Arrays.asList(names2));

        String[] returnedStringArray  = new String[0];

        return hashedSet.toArray(returnedStringArray);
    }

    public static void main(String[] args) {
        String[] names1 = new String[]{"Ava", "Emma", "Olivia"};
        String[] names2 = new String[]{"Olivia", "Sophia", "Emma"};
        System.out.println(String.join(", ", MergeNames.uniqueNames(names1, names2))); // should print Ava, Emma, Olivia, Sophia
    }
}

class QuadraticEquation {
    public static Roots findRoots(double a, double b, double c) {
        double negativeB = -(b);
        double fourAC =  4 * a * c;
        double sqrt = Math.sqrt((b * b) - (fourAC));
        double positiveQuadratic = (negativeB +  sqrt) / (2 * a);
        double negativeQuadratic = (negativeB -  sqrt) / (2 * a);

        return new Roots(positiveQuadratic, negativeQuadratic);
    }

    public static void main(String[] args) {
        Roots roots = QuadraticEquation.findRoots(2, 10, 8);
        System.out.println("Roots: " + roots.x1 + ", " + roots.x2);
    }
}

class Roots {
    public final double x1, x2;

    public Roots(double x1, double x2) {
        this.x1 = x1;
        this.x2 = x2;
    }
}
