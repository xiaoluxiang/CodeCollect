package com.lushixiang.TestSimple;

public class BitTest {
    public static void main(String[] args) {
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
}
