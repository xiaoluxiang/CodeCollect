package com.lushixiang.deadClock;import java.text.SimpleDateFormat;import java.util.*;public class DeadClockDemo {    private static String A = "A";    private static String B = "B";    private DeadClockDemo(){        System.out.println("创建DeadClockDemo开始");    }    public static void main(String[] args) {        new DeadClockDemo().DeadClockDemoRunner();        StringBuilder stringBuilder = new StringBuilder();        StringBuilder append = stringBuilder.append("1");        append.append(233);        System.out.println(append);        System.out.println(stringBuilder);//        System.out.println(append == stringBuilder);//        ArrayList<String> strings = new ArrayList<>();//        strings.add("1");//        strings.add("2");//        strings.add("3");//        strings.add("4");//        List<String> strings1 = strings.subList(2, 3);//        strings1.set(0,"subString");//        System.out.println(strings);//        // 日期：//        Date date = new Date();//        java.sql.Date date1 = new java.sql.Date(date.getTime());//        System.out.println(date.getTime());//        System.out.println("after"+date.after(date1));//        System.out.println(System.currentTimeMillis());//        System.out.println(date1);//        List<Map<Integer, String>> mapList = new ArrayList<HashMap<Integer,String>>();//        testGetInfer testGetInfer = new testGetInfer(mapList);//        testGetInfer.setList();//        byte b = 10;//        System.out.println("10".equals(Byte.toString(b)));        String s = "I am born yyyyMMdd.csv";        System.out.println(s.replace("yyyyMMdd", new SimpleDateFormat("yyyyMMdd").format(new Date())));        System.out.println(s);//        boolean b = s > (); new ArrayList<String s>()//        new DeadClockDemo().DeadClockDemoRunner();//        ArrayList<String> strings = new ArrayList<>();//        ArrayList<String> strings1 = new ArrayList<>();//        strings.add("1.yyyyMMdd");//        strings.add("2.yyyyMMdd");//        System.out.println(strings);//        strings.forEach(s -> {////            strings1.add(s.replace("yyyyMMdd",new SimpleDateFormat("yyyyMMdd").format(new Date())));}//        );//        System.out.println(strings);//        System.out.println(strings1);    }    private void DeadClockDemoRunner() {        System.out.println("DeadClockDemo 正式开始");        Thread t1 = new Thread(new Runnable() {            @Override            public void run() {                synchronized (A) {                    try {                        Thread.sleep(20000);                    } catch (InterruptedException e) {                        e.printStackTrace();                    }                    System.out.println("已获得A对象，下面开始争取B对象资源");                    synchronized (B) {                        System.out.println("AB资源皆已获得");                    }                }            }        });        Thread t2 = new Thread(new Runnable() {            @Override            public void run() {                synchronized (B) {                    try {                        Thread.sleep(20000);                    } catch (InterruptedException e) {                        e.printStackTrace();                    }                    System.out.println("已获得B对象，下面开始争取A对象资源");                    synchronized (A) {                        System.out.println("AB资源皆已获得");                    }                }            }        });        t1.start();        t2.start();    }}