package com.lushixiang.TestSimple;

public enum Operator {
    // 实现抽象方法
    ADD(1,3){
        @Override
        public int apply(int a, int b){
            return a+b;
        }
    };

    // 定义枚举属性
    public final int a ;
    public final int b;

    // 定义抽象方法
    public abstract int apply(int a, int b);

    // 定义初始化方法
    private Operator(int x1, int x2){
        a = x1;
        b = x2;
        System.out.println("Operator.ADD is init...");
    }

}
