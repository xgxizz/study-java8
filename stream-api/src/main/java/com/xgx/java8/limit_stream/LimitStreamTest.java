package com.xgx.java8.limit_stream;

import java.util.Random;

public class LimitStreamTest {
    public static void main(String[] args) {
        Random random = new Random();
        random.ints().limit(10).forEach(System.out::println);
    }
}
