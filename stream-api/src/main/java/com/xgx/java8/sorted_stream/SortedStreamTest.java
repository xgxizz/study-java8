package com.xgx.java8.sorted_stream;

import java.util.Random;

public class SortedStreamTest {
    public static void main(String[] args) {
        Random random = new Random();
        random.ints().limit(10).sorted().forEach(System.out::println);
    }
}
