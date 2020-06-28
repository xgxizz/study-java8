package com.xgx.java8.variable_scope;

//变量作用域
public class VariableScopeTester {
    interface GreetingService {
        void sayMessage(String message);
    }

    public static void main(String[] args) {
        String num = "hi";
        GreetingService greetingService = msg -> {
            System.out.println(num + msg);
        };
        //num += ",";该句如果取消注释会发生编译报错。即lambda表达式内部操作的变量必须为final类型，不能发生变化
        greetingService.sayMessage("xgx");


    }


}
