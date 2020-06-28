package com.xgx.java8.paralled_stream.threadsafe;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Description: <br/>
 * @author xgx<br />
 * date: 2020/6/28 17:55<br/>
 */
public class ThreadSafeTest {
    public static void main(String[] args) {
        List list = new ArrayList();
        String[] arr = new String[100];
        for (int i = 0; i < 100; i++) {
            arr[i] = "" + i;
        }
        List<String> strings = Arrays.asList(arr);
        strings.parallelStream().forEach(x -> list.add(x));
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
            if (!list.get(i).equals("" + i)){
                System.out.println( i + "," + list.get(i));
                System.out.println("出现了线程安全问题");
            }
        }
    }
}
