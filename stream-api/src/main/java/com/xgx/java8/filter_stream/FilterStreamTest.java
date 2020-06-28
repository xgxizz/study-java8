package com.xgx.java8.filter_stream;

import java.util.Arrays;
import java.util.List;

public class FilterStreamTest {
    public static void main(String[] args) {
        List<String> strings = Arrays.asList("abc", "", "bc", "efg", "abcd","", "jkl");
        // 获取空字符串的数量
        long count = strings.stream().filter(string -> string.isEmpty()).count();
        System.out.println("count:" + count);
    }
}
