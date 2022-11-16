package com.lushixiang.use;

import java.util.HashMap;
import java.util.concurrent.*;

public class TestThreadPool {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(10, 15, 10, TimeUnit.SECONDS, new ArrayBlockingQueue<>(10), new ThreadPoolExecutor.AbortPolicy());
        int i = 0;
        Runnable runnable = ()->{
            try {
                Thread.sleep(1000);
                System.out.println("WTF");
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        };
        do{
            threadPoolExecutor.execute(runnable);

            i++;
        }while (i<2);

//        threadPoolExecutor.shutdown();

        Callable<Object> callable = Executors.callable(runnable);
        ExecutorService fixedThreadPool = Executors.newFixedThreadPool(10);
//        Executors.newThread
        String yes = "yes";
        FutureTask<String> stringFutureTask = new FutureTask<String>(()->{
            System.out.println(yes);
        },yes);
        stringFutureTask.run();
        Boolean b = stringFutureTask.get() == yes;
        System.out.println(b);
        Thread thread = new Thread();
        thread.join();
        new HashMap<String, String>().put("","");
        new ConcurrentHashMap<String, String>().put("","");
    }
}
