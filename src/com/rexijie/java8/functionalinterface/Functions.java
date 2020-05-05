package com.rexijie.java8.functionalinterface;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.function.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static com.rexijie.util.Helper.giveSpace;
import static com.rexijie.util.Helper.printString;

/**
 * Java 8 brings some functional interfaces
 * {@link Predicate}
 * {@link BiPredicate}
 * {@link Function}
 * {@link BiFunction}
 * {@link java.util.function.Consumer}
 * {@link java.util.function.Supplier}
 *
 * you can make your own.
 * Functional interfaces generally ave one method only. and maybe some default methods
 */

interface CustomFunction<T, T2, T3, R> {
    /** This function will take three parameters of types T, T1, T2 and return a type R
     * The implementation is up to you
     * @param t first param
     * @param t2 second parameter
     * @param t3 thirdParameter
     * @return Returned data
     */

    R apply (T t, T2 t2, T3 t3);
}

public class Functions {
    static Supplier<String[]> generateDateString = () -> new Date().toString().split(" ");

    static Consumer<String> printItem = (o) -> System.out.println(o);
    static BiConsumer<String, String> printBothItems = (o, o2) -> System.out.println(o + " and the next is "+ o2);

    static Predicate<String> shorterThan5 = (str) -> str.length() < 5;
    static BiPredicate<String, Integer> stringEqualsInteger = (s, i) -> Integer.valueOf(s).equals(i);

    static Function<Integer, Integer> getSquare = (i) -> i * i;
    static BiFunction<String, String, String> concatenateString = (a, b) -> a + b;

    static CustomFunction<Integer, Integer, Integer, List<String>> squareAndReturnStrings = (i1, i2, i3) -> {
      Stream<Integer> st = Stream.of(i1, i2, i3);

      return st //Stream
              .peek(it -> printItem.accept("Peek before map -> "+it))
              .map(getSquare) // Applied Function to Map
              .map(String::valueOf)
              .filter(shorterThan5) // Applied Predicate to filter
              .peek(it -> printItem.accept("Peek after map and filter -> "+it)) // applied consumer to peek
              .collect(Collectors.toList());
    };

    public static void main(String[] args) {
        int i = 2;
        int i2 = 4;
        String s = "2";
        String s2 = " Bicycles";

        printString("int i = "+ i);
        printString("int i2 = "+ i2);
        printString("String s = "+ s);
        printString("String s2 = "+ s2);

        giveSpace();
        printString("Functions: ");
        printString("Function -> getSquare("+ i +"): "+ getSquare.apply(i));
        printString("BiFunction -> concatenateString("+ s +", "+ s2 +"): "+ concatenateString.apply(s, s2));

        giveSpace();
        printString("Predicates: ");
        printString("Predicate -> shorterThan5("+ i +"): "+ shorterThan5.test(s2));
        printString("BiPredicate -> StringEqualsInteger("+ s +", "+ i +"): "+ stringEqualsInteger.test(s, i));

        giveSpace();
        printString("Consumers: ");
        printItem.accept("Consumer -> printItem(s): "+ s);
        printBothItems.accept("Consumer -> printItems(text, s2): s1", s2);

        giveSpace();
        printString("Supplier:");
        printItem.accept("Supplier -> generateDateString: " + Arrays.toString(generateDateString.get()));

        giveSpace();
        printString("Custom Function:");
        List<String> res = squareAndReturnStrings.apply(i, i2, 30);
        printItem.accept("CustomFunction -> squareAndReturnStrings: " + Arrays.toString(res.toArray()));
    }
}
