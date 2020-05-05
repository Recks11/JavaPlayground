package com.rexijie.java8.streams;

import java.util.Arrays;
import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.stream.Stream;

class StreamStatistics {
    public static void main(String[] args) {
        List<String> numbers = Arrays.asList("3", "2", "2", "3", "7", "3", "5");

        // Summary statistics is a new class in Java8 that provides the min, max, sum and average
        IntSummaryStatistics stats = numbers.
                stream()
                .mapToInt(Integer::valueOf)
                .summaryStatistics();

        System.out.println("Highest number in List : " + stats.getMax());
        System.out.println("Lowest number in List : " + stats.getMin());
        System.out.println("Sum of all numbers : " + stats.getSum());
        System.out.println("Average of all numbers : " + stats.getAverage());
    }
}

public class StreamsDemo {
    public static void main(String[] args) {
        List<String> namesList = Arrays.asList("person", "animal", "divine", "number", "y", "z", "a");
        Stream<String> namesStream = namesList.stream();

        Stream<String> filteredNames = namesStream
                .filter(s -> s.length() != 1)
                .peek(System.out::println);

        System.out.println(Arrays.toString(filteredNames.toArray()));
    }
}
