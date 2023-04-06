package com.lushixiang.TestSimple;

import java.util.concurrent.Callable;

public class BitTest {
    public static void main(String[] args) {
//        System.out.println(1<<30);
//        int bit = 2;
//        for(int i=1; i<=30; i++){
//            bit = bit*2;
//        }
//        System.out.println(bit);
////        System.out.println(bit+(1<<30));
//        System.out.println(Integer.MAX_VALUE);
//        System.out.println(Float.MAX_VALUE);
//        System.out.println(1<<30 == bit);
        Callable<String> callable2 = new Callable<>() {
            @Override
            public String call() throws Exception {
                return null;
            }
        };


        Callable<String> callable1 = () -> {
            return "Lambda";
        };
        Callable<String> callable = callable1;
        Thread thread = new Thread((Runnable) callable);

    }

}


