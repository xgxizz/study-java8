package com.xgx.java8.foreach_stream;

import java.util.Random;

public class ForEachStramTest {
    public static void main(String[] args) {
        Random random = new Random();
        random.ints().limit(10).forEach(num -> System.out.println(num));
    }
}
