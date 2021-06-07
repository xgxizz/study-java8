package com.xgx.java8.collectors_stream;

import com.xgx.java8.Student;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class CollectorsStreamTest {
    public static void main(String[] args) {
//        List<String> strings = Arrays.asList("abc", "", "bc", "efg", "abcd","", "jkl");
//        List<String> filtered = strings.stream().filter(string -> !string.isEmpty()).collect(Collectors.toList());
//
//        System.out.println("筛选列表: " + filtered);
//        String mergedString = strings.stream().filter(string -> !string.isEmpty()).collect(Collectors.joining(", "));
//        System.out.println("合并字符串: " + mergedString);

        Stream<Student> studentStream = Stream.of(new Student("路飞", 22, 175),
                new Student("红发", 40, 180),
                new Student("白胡子", 50, 185));
        List<Student> collect = studentStream.collect(Collectors.toList());
        System.out.println(collect);
    }
}
