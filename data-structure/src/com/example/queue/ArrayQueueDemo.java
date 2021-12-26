package com.example.queue;

import java.util.Scanner;

public class ArrayQueueDemo {
    public static void main(String[] args) {
        ArrayQueue arrayQueue = new ArrayQueue(3);
        char key = ' '; // 接受输入
        Scanner scanner = new Scanner(System.in);
        boolean loop = true;
        // 输出菜单
        while (loop){
            System.out.println("s(show): 显示队列");
            System.out.println("a(add): 添加数据到队列");
            System.out.println("g(get): 从队列中取出数据");
            System.out.println("h(head): 从队列中取出数据");
            System.out.println("e(exit): 退出队列");
            key = scanner.next().charAt(0); // 接受输入字符
            switch (key){
                case 's':
                    arrayQueue.showQueue();
                    break;
                case 'a':
                    System.out.println("请输入一个数");
                    arrayQueue.addQueue(scanner.nextInt());
                    break;
                case 'g':
                    try {
                        System.out.printf("取出的数据是：%d\n", arrayQueue.getQueue());
                    } catch (Exception e){
                        System.out.println(e.getMessage());
                    }
                case 'h':
                    try {
                        System.out.printf("队列头数据为：%d\n", arrayQueue.headQueue());
                    } catch (Exception e){
                        System.out.println(e.getMessage());
                    }
                case 'e':
                    scanner.close();
                    break;
                default:
                    throw new RuntimeException("无效的输入！");
            }
        }
        System.out.println("结束！");
    }
}

/**
 * 使用数组模拟队列
 */
class ArrayQueue {
    private int maxSize; // 表示该数组队列的最大值
    private int front; // 队列头
    private int rear; // 队列尾
    private int[] array; // 模拟队列

    // 创建队列的构造方法
    public ArrayQueue(int arrayMaxSize) {
        maxSize = arrayMaxSize;
        array = new int[maxSize];
        front = -1; // 指向队列头部，分析出front是指向队列头的前一个位置
        rear = -1; // 指向队列尾，指向队列尾的数据(即就是队列最后一个数据)
    }

    // 判断队列是否满
    public boolean isFull() {
        return rear == maxSize - 1;
    }

    // 判断队列是否为空
    public boolean isEmpty() {
        return rear == front;
    }

    // 往队列里添加数据
    public void addQueue(int n) {
        // 判断队列是否满
        if (isFull()) {
            throw new RuntimeException("队列已满，无法添加数据");
        }
        rear++; // rear后移
        array[rear] = n;
    }

    // 获取队列数据，出队列
    public int getQueue() {
        // 判断队列是否为空
        if (isEmpty()) {
            throw new RuntimeException("队列为空，无法获取数据");
        }
        front++; // front后移
        return array[front];
    }

    // 显示队列的所有数据
    public void showQueue() {
        // 遍历
        if (isEmpty()) {
            System.out.println("队列为空");
            return;
        }
        for (int i = 0; i < array.length; i++) {
            System.out.printf("array[%d]=%d\n", i, array[i]);
        }
    }

    // 显示队列的头数据
    public int headQueue() {
        if (isEmpty()) {
            throw new RuntimeException("队列为空");
        }

        return array[front + 1];
    }
}


