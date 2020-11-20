package com.xgx.java8;

import java.math.BigDecimal;
import java.util.function.*;

/**
 * Description: 函数接口是只有一个抽象方法的接口，用作 Lambda 表达式的类型。使用@FunctionalInterface注解修饰的类，编译器会检测该类是否只有一个抽象方法或接口，否则，会报错。<br/>
 * @author: xgx <br/>
 * date: 2020/11/20 10:26 <br/>
 */
public class Test {
    public static void main(String[] args) {
        Student student = new Student("9龙", 23, 175);
        Predicate<Integer> predicate = x -> x > 185;
        System.out.println("9龙的身高高于185吗？：" + predicate.test(student.getStature()));
        Consumer<String> consumer = System.out::println;
        consumer.accept("lalala");
        consumerStudent(stu -> System.out.println(stu));

        Function<Student, String> function = Student::getName;
        String studentName = function.apply(student);
        System.out.println(studentName);

        Supplier<Integer> supplier = () -> Integer.valueOf(BigDecimal.TEN.toString());
        Integer integer = supplier.get();
        System.out.println(integer);

        UnaryOperator<Student> unaryOperator = stu -> new Student(stu.getName(),stu.getAge() + 10, stu.getStature());
        System.out.println(unaryOperator.apply(student));

        BinaryOperator<Student> binaryOperator = (stu1, stu2) ->{
            Student newStu = stu1;
            if (stu1.getName().equals(stu2.getName())){
                newStu.setAge(stu2.getAge());
            }
            return newStu;
        };
        Student applyStu = binaryOperator.apply(new Student("李阳", 23, 175), new Student("李阳", 99, 175));
        System.out.println(applyStu);

        test(() -> "我是一个演示的函数式接口");

        String work = new Worker() {
            @Override
            public String work() {
                return "我是一个演示的函数式接口";
            }
        }.work();
    }
    private static void consumerStudent(Consumer<Student> consumer){
        consumer.accept(new Student("xgx", 25, 175));
        consumer.accept(new Student("zhengzheng", 25, 165));
    }

    /**
     * 演示自定义函数式接口使用
     *
     * @param worker
     */
    public static void test(Worker worker) {
        String work = worker.work();
        System.out.println(work);
    }
}
