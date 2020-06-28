package com.xgx.java8.paralled_stream.rate;

import java.io.Serializable;
import java.time.Duration;
import java.time.Instant;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveTask;
import java.util.stream.LongStream;
import java.util.stream.Stream;

public class ForkJoinCalculate extends RecursiveTask<Long> implements Serializable {
    private static final long serialVersionUID = 2462375556031755900L;


    private long start;

    private long end;

    private static final long THRESHOLD = 10000L;//临界值

    public ForkJoinCalculate(long start, long end) {
        this.start = start;
        this.end = end;
    }

    @Override
    protected Long compute() {
        long length = end -start;
        if(length<=THRESHOLD){
            long sum =0;
            for (long i = start; i <=end ; i++) {
                sum+=i;
            }
            return sum;
        }else {
            long middle =(start+end)/2;
            ForkJoinCalculate left = new ForkJoinCalculate(start, middle);
            left.fork();//拆分，并将该子任务压入线程队列
            ForkJoinCalculate right = new ForkJoinCalculate(middle + 1, end);
            right.fork();
            return left.join()+right.join();
        }
    }

    public static void main(String[] args) {
        Instant start = Instant.now();

        ForkJoinPool pool = new ForkJoinPool();
        ForkJoinCalculate task = new ForkJoinCalculate(0, 10000000000L);
        Long sum = pool.invoke(task);
        System.out.println(sum);
        Instant end = Instant.now();
        System.out.println("耗费时间"+ Duration.between(start,end).toMillis());//1668

//        Instant start2 = Instant.now();
//        long sum2 = 0L;
//        for (long i = 0L; i < 10000000000L; i++) {
//            sum+=i;
//        }
//        System.out.println(sum2);
//        Instant end2 = Instant.now();
//        System.out.println("耗费时间"+Duration.between(start2,end2).toMillis());//26506


//        Instant start3 = Instant.now();
//        long sum3 = LongStream.rangeClosed(0, 10000000000L).parallel().sum();
//        System.out.println(sum3);
//        Instant end3 = Instant.now();
//        System.out.println("耗费时间"+Duration.between(start3,end3).toMillis());//1784

        Instant start4 = Instant.now();
        Long reduce = Stream.iterate(1L, x -> x + 1).limit(10000000000L).parallel().reduce(0L, Long::sum);
        System.out.println(reduce);
        Instant end4 = Instant.now();
        System.out.println("耗费时间"+Duration.between(start4,end4).toMillis());

    }



}

