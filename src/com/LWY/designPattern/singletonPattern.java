package com.LWY.designPattern;

public class singletonPattern {
    public static void main(String[] args) {
        singleton instance1 = singleton.getInstance();
        singleton instance2 = singleton.getInstance();
        singleton instance3 = singleton.getInstance();


    }
}

class singleton {

    private static singleton instance = new singleton();

    private singleton(){

    }

    public static singleton getInstance(){
        return instance;
    }


}