package com.LWY.TestExample;


class A{
    static{
        System.out.print("1");
    }
    public A(){
        System.out.print("2");
    }
}
class B extends A{
    static{
        System.out.print("a");
    }
    public B(){
        //super();

        System.out.print("b");
    }
}
public class test {

//    public static void main(String[] args) {
//        A ab = new B();
//        //
//        ab = new B();
//    }

    public static void main(String[] args) {
        A ab = new B();
        ab = new B();
    }
}
