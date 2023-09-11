package com.LWY.stack;

import java.util.Scanner;

public class ListStackDemo1 {
    public static void main(String[] args) {
        LLStack llStack = new LLStack();

        String key = "";
        boolean loop = true;//控制是否退出菜单
        Scanner scanner = new Scanner(System.in);

        while(loop) {
            System.out.println("list: 表示显示栈");
            System.out.println("exit: 退出程序");
            System.out.println("push: 表示添加数据到栈(入栈)");
            System.out.println("pop: 表示从栈取出数据(出栈)");
            System.out.println("top: 表示栈顶数据(不出栈)");
            System.out.println("length: 表示此时栈中数据的个数");
            System.out.println("请输入你的选择");

            key = scanner.next();
            switch (key) {
                case "list" :
                    llStack.list();
                    break;
                case "push" :
                    System.out.println("请输入一个数");
                    int value = scanner.nextInt();
                    LLNode node = new LLNode(value);
                    llStack.push(value);
                    break;
                case "pop" :
                    try {
//                        llStack.pop().toString();
                        int res = llStack.pop();
                        System.out.printf("出栈的数据是 %d\n", res);
                        System.out.println("此时栈中元素个数为：" + llStack.getLength());
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case "length" :
                    int count = llStack.getLength();
                    System.out.println("栈里面值的个数为：" + count);
                    break;
                case "top" :
                    System.out.println("栈顶的值为：" + llStack.top());
                    break;
                case "exit" :
                    scanner.close();
                    loop = false;
                    break;
                default:
                    break;
            }
        }

        System.out.println("程序退出~~~");

//        llStack.push(1);
//        llStack.push(2);
//        llStack.push(3);
//        System.out.println("栈里面值的个数为：" + llStack.getLength());
//        llStack.pop();
//        System.out.println("pop一个之后，栈里面的个数 为 ：" + llStack.getLength());
//        System.out.println("pop一个之后，栈顶的值为：" + llStack.top());
    }
}

class LLStack {
    LLNode headnode = null;

    public LLStack() {
        headnode = new LLNode(-1);//先初始化
    }

    public boolean isEmpty() {//判断是否为空的
        return headnode.getData() == -1;
    }

    public void push(int data) {//入栈
        if (headnode.getData() == -1) {//判断头结点的值为空的时候
            headnode.setData(data);
        } else if (headnode == null) {
            headnode = new LLNode(data);
        } else {
            LLNode newnode = new LLNode(data);
            newnode.setNext(headnode);
            headnode = newnode;
        }
    }


    public int pop() {//出栈(返回栈顶的值，并且删除)
        int data = 0;
        if (isEmpty()) {
            //抛出异常
            throw new RuntimeException("栈空，没有数据~");
        }
        data = headnode.getData();
        headnode = headnode.getNext();
        return data;
    }

    public int top() {//返回栈顶的值，但是不删除
        int data = 0;
        if (isEmpty()) {
            System.out.println("栈为空，返回值为0");
            return 0;
        }
        data = headnode.getData();
        return data;
    }

    public void list() {
        //显示链表[遍历]
        int length = getLength();
        int i = 0;
        //判断链表是否为空
        if (isEmpty()) {
            System.out.println("链表为空");
            return;
        }

        LLNode temp = headnode;
        while (true) {
            //判断是否到链表最后
            if (temp == null) {
                break;
            }
            //输出节点的信息
            int data = temp.getData();
            System.out.println("stack[" + (--length) + "]=" + data);
            temp = temp.getNext();
        }

    }

    public int getLength() {//得到栈里面值的个数
        int count = 0;
        LLNode tempnode = headnode;
        if (isEmpty() || tempnode.getData() == -1)//当头结点为空，并且值也为空的时候就返回0
        {
            count = 0;
        } else {
            while (tempnode != null) {
                count++;
                tempnode = tempnode.getNext();
            }
        }
        return count;
    }

}

class LLNode {
    private int data;//存放数据
    private LLNode next;//指向下一个节点

    public LLNode() {

    }

    public LLNode(int data) {
        this.data = data;
    }

    public int getData() {
        return data;
    }

    public void setData(int data) {
        this.data = data;
    }

    public LLNode getNext() {
        return next;
    }

    public void setNext(LLNode next) {
        this.next = next;
    }
}
