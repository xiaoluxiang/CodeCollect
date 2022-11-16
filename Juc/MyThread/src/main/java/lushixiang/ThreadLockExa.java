package lushixiang;

import java.io.File;
import java.io.PrintStream;

public class ThreadLockExa {
    public static void main(String[] args) throws InterruptedException {
        System.out.println(File.separator);
        System.out.println(File.separatorChar);
        System.out.println(File.pathSeparator);
        System.out.println(File.pathSeparatorChar);
        System.out.println(System.lineSeparator());
        System.out.println("over");
        System.out.println("Main thread ....");
        Thread previous = Thread.currentThread();
        Thread thread01 = new Thread(() -> {
            System.out.println("01 thread running");
            ThreadLocal<String> threadLocal01 = new ThreadLocal<>();
            threadLocal01.set("01ThreadLocal_value");
            try {
                Thread.sleep(1000);
                synchronized (previous){
                    System.out.println("获取到Main thread的锁");
                    System.out.println(previous.isAlive());
//                    previous.wait();
                }
                System.out.println("previous.join()...");
                previous.join();


            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            String s = threadLocal01.get();
            System.out.println("01 Thread threadLocal value: "+s);
            threadLocal01.remove();
        }, "01");
        thread01.start();
//        Thread.sleep(1000);
        System.out.println("Main thread over ....");
    }
}
