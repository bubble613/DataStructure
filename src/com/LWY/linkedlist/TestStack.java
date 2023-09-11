package com.LWY.linkedlist;

import java.util.Stack;

public class TestStack {
    public static void main(String[] args) {
        Stack<String> stack = new Stack<>();

        //入栈
        stack.add("jack");
        stack.add("tom");
        stack.add("smith");

        stack.push("lixx");

        // 出栈
        // smith, tom , jack
        while (stack.size() > 0) {
            System.out.println(stack.pop());//pop就是将栈顶的数据取出
        }

    }
}
