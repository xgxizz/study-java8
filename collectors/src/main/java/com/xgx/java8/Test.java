package com.xgx.java8;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * Description: <br/>
 *
 * @author: xgx <br/>
 * date: 2020/11/26 18:45 <br/>
 */
public class Test {
    public static void main(String[] args) {
        List<String> list = Arrays.asList("jack", "bob", "alice", "mark");
        List<String> duplicateList = Arrays.asList("jack", "jack", "alice", "mark");

        //1.Collectors.toList()
        //将stream转换为list
        List<String> listResult = list.stream().collect(Collectors.toList());
        System.out.println(listResult);
        //2.Collectors.toSet()
        //将stream转换为set
        Set<String> setResult = list.stream().collect(Collectors.toSet());
        System.out.println(setResult);
        //将stream转换为set,并进行了去重
        Set<String> duplicateSetResult = duplicateList.stream().collect(Collectors.toSet());
        System.out.println(duplicateSetResult);
        //3.Collectors.toCollection()
        List<String> custListResult = list.stream().collect(Collectors.toCollection(LinkedList::new));
        System.out.println(custListResult);
        //4.Collectors.toMap()
        Map<String, Integer> mapResult = list.stream().collect(Collectors.toMap(Function.identity(), String::length));
        System.out.println(mapResult);
        //如果stream中有重复的值，则转换会报IllegalStateException: Duplicate key 4异常：
//        Map<String, Integer> duplicateMapResult = duplicateList.stream()
//                .collect(Collectors.toMap(Function.identity(), String::length));
//        System.out.println(duplicateMapResult);
        Map<String, Integer> duplicateMapResult2 = duplicateList.stream()
                .collect(Collectors.toMap(Function.identity(), String::length, (item, identicalItem) -> item));
        System.out.println(duplicateMapResult2);
        //5.Collectors.collectingAndThen():collectingAndThen允许我们对生成的集合再做一次操作。
        String collectAndThenResult = list.stream()
                .collect(Collectors.collectingAndThen(Collectors.toList(), l -> {
                    return l.get(0);
                }));
        System.out.println(collectAndThenResult);

        //6.Collectors.joining()
        String joinResult = list.stream().collect(Collectors.joining());
        System.out.println(joinResult);
        String joinResult1 = list.stream().collect(Collectors.joining(" "));
        System.out.println(joinResult1);
        String joinResult2 = list.stream().collect(Collectors.joining(" ", "xgx-prefix-","-xgx-suffix"));//在拼接后加上前缀和后缀
        System.out.println(joinResult2);
        //7.Collectors.counting()
        Long countResult = list.stream().collect(Collectors.counting());
        System.out.println(countResult);
        //8.Collectors.summarizingDouble/Long/Int() SummarizingDouble/Long/Int为stream中的元素生成了统计信息，返回的结果是一个统计类：
        IntSummaryStatistics intResult = list.stream()
                .collect(Collectors.summarizingInt(String::length));
        System.out.println(intResult);
        //9.Collectors.averagingDouble/Long/Int() averagingDouble/Long/Int()对stream中的元素做平均：
        Double averageResult = list.stream().collect(Collectors.averagingInt(String::length));
        System.out.println(averageResult);
        //10.Collectors.summingDouble/Long/Int() summingDouble/Long/Int()对stream中的元素做sum操作
        Double summingResult = list.stream().collect(Collectors.summingDouble(String::length));
        System.out.println(summingResult);
        //11.Collectors.maxBy()/minBy() maxBy()/minBy()根据提供的Comparator，返回stream中的最大或者最小值：
        Optional<String> maxByResult = list.stream().collect(Collectors.maxBy(Comparator.naturalOrder()));
        System.out.println(maxByResult);
        //12.Collectors.groupingBy() GroupingBy根据某些属性进行分组，并返回一个Map：
        Map<Integer, Set<String>> groupByResult = list.stream()
                .collect(Collectors.groupingBy(String::length, Collectors.toSet()));
        System.out.println(groupByResult);
        //13.Collectors.partitioningBy()  PartitioningBy是一个特别的groupingBy，PartitioningBy返回一个Map，这个Map是以boolean值为key，从而将stream分成两部分，一部分是匹配PartitioningBy条件的，一部分是不满足条件的：
        Map<Boolean, List<String>> partitionResult = list.stream()
                .collect(Collectors.partitioningBy(s -> s.length() > 3));
        System.out.println(partitionResult);
    }
}
