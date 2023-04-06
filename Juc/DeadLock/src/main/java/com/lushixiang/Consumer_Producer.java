package com.lushixiang;

import java.util.TreeSet;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * &#064;author:  lushixiang
 * &#064;description:  JUC中常见工具类实现生产者交易者模式
 * &#064;createDate:  2023/03/24  */


public class Consumer_Producer {

    private TreeSet<Integer> pool = new TreeSet<>();
    public Integer count = 1;

    public void consumer() {
        synchronized (pool){
            if(pool.size()>0){
                System.out.println("consumer working...");
                System.out.println(pool.pollFirst());
                pool.notifyAll();
            }
            else {
                try{
                    System.out.println("consumer work wating...");
                    pool.wait();
                }catch (InterruptedException e){
                    System.out.println("consumer is interrupted...");
                }
            }
        }
    }

    public void producer() {
        synchronized (pool){
            if(pool.size()<=10){
                System.out.println("producer working...");
                pool.add(count++);
                pool.notifyAll();
            }
            else {
                System.out.println("producer worker waiting...");
                pool.notifyAll();
            }
        }
    }

    public static void main1(String[] args) {
        Consumer_Producer consumerProducer = new Consumer_Producer();
        new Thread(new Runnable() {
            @Override
            public void run() {
                while(true){
                    try{
                        Thread.sleep(1000);
                    }catch(InterruptedException e){
                        System.out.println(e);
                    }
                    consumerProducer.consumer();
                }
            }
        }).start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                while(true){
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        System.out.println(e);
                    }
                    consumerProducer.producer();
                }
            }
        }).start();
    }




}
/**
 * CountDownLatch的测试方法如下：
 * public static void main(String[] args) {
 *      new TestCountDownLatch().run();
 * }
 */
class TestCountDownLatch{
    public void run() {
        CountDownLatch countDownLatch = new CountDownLatch(3);
        for (int i = 0; i < 4; i++) {
            int finalI = i;
            Runnable runner;
            if (i == 1) {
                runner = () -> {
                    try {
                        System.out.println(finalI);
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                    try {
                        System.out.println("childThread is going to await...");
                        countDownLatch.await();
                        System.out.println("childThread is start again");
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                };
            } else {
                runner = () -> {

                    try {
                        System.out.println(finalI);
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                    countDownLatch.countDown();
                };

            }
            new Thread(runner).start();
        }
        System.out.println("main thread is going to await...");
        try {
            countDownLatch.await();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println("main thread is over...");


    }
}


/**
 * this class is used to use lock and condition*/
class tickets{
    private int num = 0;
    ReentrantLock lock = new ReentrantLock();

    Condition nonum = lock.newCondition();
    Condition havenum = lock.newCondition();


    public void put() {
        while(true) {
            lock.lock();
            if (num >= 10) {
                try {
                    nonum.await();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }else System.out.printf("producer working ... and plus from %d to %d \n", num, ++num);
            havenum.signalAll();
            lock.unlock();
        }
    }


    public void take() {
        while(true) {
            lock.lock();
            if (num <= 0) {
                try {
                    havenum.await();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
            else System.out.printf("consumer working ... and del from %d to %d \n", num, --num);
            nonum.signalAll();
            lock.unlock();
        }
    }

    public static void main(String[] args) {
        Integer integer = new Integer(1);
        int a = 1;
        Integer b = 1;
        System.out.println(a ==integer);
        System.out.println(a==b);
        int d=1;
        System.out.println(Bird.testReturn());
    }

}
class Bird{
    public static int testReturn(){
        int x =10;
        int y =10;
        System.out.println("x+y="+x+y);
//        System.out.println("x-y="+x-y);
        System.out.println("x*y="+x*y);
        System.out.println("x/y="+x/y);

        int a = 0;
        return ++a + a++ + ++a;
    }

}

