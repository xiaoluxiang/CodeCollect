package com.lushixiang.TestSimple;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.Future;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class InitSequenceTest {


    private int j = getI();
    private int i = 1;

    public InitSequenceTest() {
        i = 2;
    }

    private int getI() {
        return i;
    }


    public static void main_1(String[] args) throws InterruptedException {

//        System.out.println(new InitSequenceTest().j);
        System.out.println(Runtime.getRuntime().availableProcessors());
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(2, 4, 100, TimeUnit.SECONDS, new ArrayBlockingQueue<>(10), new ThreadPoolExecutor.DiscardOldestPolicy());
        System.out.println(Thread.currentThread().getName());
        for (int i = 0; i < 200; i++) {
            threadPoolExecutor.execute(new Runnable() {
                @Override
                public void run() {
                    System.out.println(Thread.currentThread().getName());
                    try {
//                        System.out.println(i);
                        Thread.sleep(10);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            });
        }
        Thread.sleep(100);
        threadPoolExecutor.shutdown();
    }
    public void testClone(){
        BitTest bitTest = new BitTest();
//        bitTest.
    }

    public static void main(String[] args) {
        System.out.println(Operator.ADD.a);
        Operator add = Operator.ADD;
        System.out.println(add.apply(1, 3));
    }
}