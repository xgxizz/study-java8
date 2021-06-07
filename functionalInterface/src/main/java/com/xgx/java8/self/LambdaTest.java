package com.xgx.java8.self;

public class LambdaTest {
 
    @FunctionalInterface
    interface IMath{
        int operation(int a, int b);
    }
     
 
    int testLambda(IMath lambdaTest, int a , int b) {
      return lambdaTest.operation(a,b);
    }
 
    public static void main(String[] args) {
        LambdaTest lambdaTest = new LambdaTest();
 
        int result = lambdaTest.testLambda(
                (a,b) -> a + b
                , 1, 2);
        System.out.println(result);
    }
}