package com.lushixiang.TestSimple;

import java.util.Optional;
import java.util.regex.Pattern;

public class BitTest implements Cloneable{
    public static void main(String[] args) {
        System.out.println(new BitTest().mainr());
        System.out.println(1<<30);
        int bit = 2;
        for(int i=1; i<=30; i++){
            bit = bit*2;
        }
        System.out.println(bit);
//        System.out.println(bit+(1<<30));
        System.out.println(Integer.MAX_VALUE);
        System.out.println(Float.MAX_VALUE);
        System.out.println(1<<30 == bit);
    }

    public int mainr() {


        try{
         int a = 0;
         for(int ii =0; ii<15; ii++){
             a++;
             Thread.sleep(100);
         }
        }catch(InterruptedException e){
            e.printStackTrace();
        }
        return 1;
    }

}
