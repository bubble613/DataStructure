package com.LWY.stack;

import java.util.Scanner;

public class ListStackDemo {
    public static void main(String[] args) {

        //测试一下ListStackDemo 是否正确
        //先创建一个 ListStack 对象->表示栈
        ListNode node1 = new ListNode(10);
        ListNode node2 = new ListNode(20);
        ListNode node3 = new ListNode(30);
        ListNode node4 = new ListNode(40);

        ListStack listStack = new ListStack();

//        listStack.push(node1);
//        listStack.push(node2);
//        listStack.push(node3);
//        listStack.push(node4);

        String key = "";
        boolean loop = true;//控制是否退出菜单
        Scanner scanner = new Scanner(System.in);

        while(loop) {
            System.out.println("show: 表示显示栈");
            System.out.println("exit: 退出程序");
            System.out.println("push: 表示添加数据到栈(入栈)");
            System.out.println("pop: 表示从栈取出数据(出栈)");
            System.out.println("请输入你的选择");

            key = scanner.next();
            switch (key) {
                case "show" :
                    listStack.list();
                    break;
                case "push" :
                    System.out.println("请输入一个数");
                    int value = scanner.nextInt();
                    ListNode node = new ListNode(value);
                    listStack.push(node);
                    break;
                case "pop" :
                    try {
                        int res = listStack.pop();
                        System.out.printf("出栈的数据是 %d\n", res);
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
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

    }
}

class ListStack {
    //先初始化一个头节点, 头节点不要动, 不存放具体的数据
    private ListNode head = new ListNode(0);

    //返回头节点
    public ListNode getHead() {
        return head;
    }

    //栈空
    public boolean isEmpty() {
        return head.next == null;
    }

    //添加节点到单向链栈
    //思路，当不考虑编号顺序时
    //1. 找到当前链表的最后节点
    //2. 将最后这个节点的next 指向 新的节点
    public void push(ListNode listStackNode) {

        //因为head节点不能动，因此我们需要一个辅助遍历 temp
        ListNode temp = head;
        //遍历链表，找到最后
        while(true) {
            //找到链表的最后
            if(temp.next == null) {//
                break;
            }
            //如果没有找到最后, 将将temp后移
            temp = temp.next;
        }
        //当退出while循环时，temp就指向了链表的最后
        //将最后这个节点的next 指向 新的节点
        temp.next = listStackNode;
    }

    //出栈节点
    //思路
    //1. head 不能动，因此我们需要一个temp辅助节点找到待删除节点的前一个节点
    //2. 说明我们在比较时，是temp.next.no 和  需要删除的节点的no比较
    public int pop() {
        ListNode temp = head;
        boolean flag = false; // 标志栈是否为空
        int length = 0;
        while(true) {
            if(temp.next == null) { //已经到链表的最后
                break;
            }

            temp = temp.next; //temp后移，遍历
            length++;
            flag = true;
        }
        //判断flag
        if(flag) { //栈不为空
            //可以删除
            int value = temp.next.next.num;
            temp.next = temp.next.next;
            return value;
        }else {
            throw new RuntimeException("栈空，没有数据~");
        }
    }

    //显示链表[遍历]
    public void list() {
        //判断链表是否为空
        if(head.next == null) {
            System.out.println("链表为空");
            return;
        }
        //因为头节点，不能动，因此我们需要一个辅助变量来遍历
        ListNode temp = head.next;
        while(true) {
            //判断是否到链表最后
            if(temp == null) {
                break;
            }
            //输出节点的信息
            System.out.println(temp.num);
            //将temp后移， 一定小心
            temp = temp.next;
        }
    }
}

//定义ListNode ， 每个ListNode 对象就是一个节点
class ListNode {
    public int num;
    public ListNode next; //指向下一个节点

    //构造器
    public ListNode(int num) {
        this.num = num;
    }

    //为了显示方法，我们重新toString
    @Override
    public String toString() {
        return "ListNode [num=" + num + "]";
    }

}
