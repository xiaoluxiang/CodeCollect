package com.lushixiang.virtualExecutor;

public class StaticDispatch {

    public void sayHello(Human human){
        System.out.println("This is human");
    }

    public void sayHello(Man man){
        System.out.println("This is man");
    }

    public void sayHello(Woman woman){
        System.out.println("This is woman");
    }

    public static void main(String[] args) {
        Human man = new Man();
        Human woman = new Woman();

        Man man1 = new Man();

        StaticDispatch staticDispatch = new StaticDispatch();

        staticDispatch.sayHello(man);
        staticDispatch.sayHello(woman);
        staticDispatch.sayHello((Human) man1);

        Lushixiang lushixiang = new Lushixiang();


        System.out.println(Lushixiang.class.getSimpleName());
        // 通过全名称
        System.out.println(Lushixiang.class.getName());
        try {
            System.out.println(Class.forName("com.lushixiang.virtualExecutor.Lushixiang"));
        }catch(ClassNotFoundException e){
            System.out.println("Class not found exception");
        }
    }

}
class Human{

    {
        System.out.println("human");
    }
}
class Man extends Human{

}
class Woman extends Human{

}

interface inter{
    int value = 10;
}

class Lushixiang extends Man implements inter{


}

