package com.xgx.java8.demo202305;

import java.util.Comparator;
import java.util.function.Consumer;

public class LambdaTest {
    public static void main(String[] args) {
        //1.无参无返回值
        Runnable r1 = () -> {
            System.out.println("hello Lambda!");
        };
        //2.一个参数无返回值
        Consumer<String> con = (String str) -> {
            System.out.println(str);
        };
        //3.数据类型可省略，因为可由编译器推断得出，称为类型推断
        Consumer<String> con2 = (str) -> {
            System.out.println(str);
        };
        //4.若只需要一个参数时，小括号可以省略
        Consumer<String> con3 = str -> {
            System.out.println(str);
        };
        //5.两个以上的参数，多条执行语句，并且可以有返回值
        Comparator<Integer> com = (o1, o2) -> {
            System.out.println(o1);
            System.out.println(o2);
            return Integer.compare(o1,o2);
        };
        //6.只有一条语句时，return和大括号若有，都可以省略
        Comparator<Integer> com2 = (o1, o2) -> Integer.compare(o1,o2);
    }
}
