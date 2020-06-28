package com.xgx.java8.generate_stream;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class GenerateStreamTest {
    public static void main(String[] args) {
        List<String> strings = Arrays.asList("abc", "", "bc", "efg", "abcd", "", "jkl");
        List<Object> collect = strings.stream().filter(str -> !str.isEmpty()).collect(Collectors.toList());
        System.out.println(strings);
        System.out.println(collect);
    }
}
