package com.LWY.queue;

import java.util.Scanner;

public class CircleArrayQueueDemo {
    public static void main(String[] args) {

        // 测试一下代码
        System.out.println("测试数组模拟环形队列的案例~~");

        // 创建一个环形队列
        CircleArray queue = new CircleArray(4); // 说明：设置为4其队列有效的数据个数为3
        char key = ' '; //接收用户的输入
        Scanner scanner = new Scanner(System.in);
        boolean loop = true;
        // 输出一个菜单
        while(loop) {
            System.out.println("s(show): 显示队列");
            System.out.println("e(exit): 退出程序");
            System.out.println("a(add): 添加数据到队列");
            System.out.println("g(get): 取出队列的数据");
            System.out.println("h(head): 查看队列的头部数据");

            key = scanner.next().charAt(0); //接收一个字符

            switch (key) {
                case 's':
                    queue.showQueue();
                    break;
                case 'a':
                    System.out.println("请输入一个数");
                    int value = scanner.nextInt();
                    queue.addQueue(value);
                    break;
                case 'g': //取出数据
                    try {
                        int res = queue.getQueue();
                        System.out.printf("取出的数据为:%d\n", res);
                    }catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    break;

                case 'h':
                    try {
                        int res = queue.headQueue();
                        System.out.printf("队列头的数据为:%d\n", res);
                    }catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    break;

                case 'e':
                    scanner.close();
                    loop = false;
                    break;

                default:
                    break;
            }
        }
        System.out.println("程序退出");


    }

}

class CircleArray {
    private int maxSize; //表示数组的最大容量
    private int front; //队列头
    //front 变量的含义做一个调整： front 就指向队列的第一个元素, 也就是说 arr[front] 就是队列的第一个元素
    //front 的初始值 = 0
    private int rear; //队列尾
    //rear 变量的含义做一个调整：rear 指向队列的最后一个元素的后一个位置. 因为希望空出一个空间做为约定.
    //rear 的初始值 = 0
    private int[] arr; //该数组存放数据，模拟队列

    //创建队列的构造器
    public CircleArray(int arrMaxSize) {
        maxSize = arrMaxSize;
        arr = new int[maxSize];
        // front = 0;
        // rear = 0; //默认都为0，可以不写
    }

    // 判断队列是否满
    public boolean isFull() {
        return (rear + 1) % maxSize == front;
    }

    //判断队列是否为空
    public boolean isEmpty() {
        return rear == front;
    }

    //添加数据到队列
    public void addQueue(int n) {
        //判断队列是否满
        if(isFull()) {
            System.out.println("队列满，不能添加数据~~");
            return;
        }
        arr[rear] = n;
        rear = (rear + 1) % maxSize; //将rear后移，这里必须考虑取模
    }

    // 读取队列中的数据
    public int getQueue() {
        //判断队列是否为空
        if(isEmpty()) {
            throw new RuntimeException("队列为空，不能取数据~~");

        }
        //这里需要注意 front是指向队列中的第一个元素
        // 1. 先将front的值保存在一个临时变量中
        // 2. 将front指针后移 这里需要考虑取模
        // 3. 将之前保存的临时变量返回
        int value = arr[front];
        front = (front + 1) % maxSize;
        return value;
    }

    //显示队列的所有数据
    public void showQueue() {
        //遍历
        if(isEmpty()) {
            System.out.println("队列空，没有数据");
            return;
        }
        for (int i = front; i < front + size(); i++) {
            System.out.printf("arr[%d] = %d\n", i % maxSize, arr[i % maxSize]);
        }
    }

    // 求出当前队列数据的有效个数
    public int size() {
        // rear = 0;
        // front = 2;
        // maxSize = 3;
        return (rear + maxSize - front) % maxSize;
    }

    //显示队列的头数据，注意不是取出数据
    public int headQueue() {
        //判断
        if(isEmpty()) {
            throw new RuntimeException("队列为空，没有头数据~~");
        }
        return arr[front];
    }
}
