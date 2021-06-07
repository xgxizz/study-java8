package com.xgx.java8;

/**
 * Description: <br/>
 *
 * @author: xgx <br/>
 * date: 2020/11/20 10:28 <br/>
 */
public class Student {
    private String name;
    private int age;
    private int stature;

    public Student() {
    }

    public Student(String name, int age, int stature) {

        this.name = name;
        this.age = age;
        this.stature = stature;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getStature() {
        return stature;
    }

    public void setStature(int stature) {
        this.stature = stature;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", stature=" + stature +
                '}';
    }
}
