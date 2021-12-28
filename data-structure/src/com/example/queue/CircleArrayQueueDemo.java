package com.example.queue;

import java.sql.Array;
import java.util.Scanner;

public class CircleArrayQueueDemo {
    public static void main(String[] args) {
        CircleArray arrayQueue = new CircleArray(4);
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
                    break;
                case 'h':
                    try {
                        System.out.printf("队列头数据为：%d\n", arrayQueue.headQueue());
                    } catch (Exception e){
                        System.out.println(e.getMessage());
                    }
                    break;
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

class CircleArray {
    private int maxSize;
    private int front; // 队列头
    private int rear; // 队列尾
    private int[] arr; // 存放数据，模拟队列

    public CircleArray(int arrMaxSize) {
        this.maxSize = arrMaxSize;
        this.front = 0;
        this.rear = 0;
        this.arr = new int[maxSize];
    }

    /**
     * 判断队列是否已满
     * @return
     */
    public boolean isFull() {
        return (rear + 1) % maxSize == front;
    }

    /**
     * 判断队列是否为空
     * @return
     */
    public boolean isEmpty() {
        return rear == front;
    }

    /**
     * 添加数据到队列
     * @param n 添加的数据
     */
    public void addQueue(int n) {
        // 判断队列是否已满
        if (isFull()) {
            System.out.println("队列满，不能添加数据");
            return;
        }

        // 直接将数据加入
        arr[rear] = n;

        // rear后移
        rear = (rear + 1) % maxSize;
    }

    public int size() {
        return (rear + maxSize - front) % maxSize;
    }

    /**
     * 获取队列的数据，出队列
     * @return
     */
    public int getQueue() {
        // 判断队列是否为空
        if (isEmpty()) {
            System.out.println("队列空不能取数据");
        }

        int value = arr[front];
        front = (front + 1) % maxSize;
        return value;
    }

    /**
     * 显示队列的所有数据
     */
    public void showQueue() {
        if (isEmpty()){
            System.out.println("队列为空");
        }
        // 从front开始遍历，遍历多少个元素
        for (int i = front; i < front + size(); i++) {
            System.out.printf("arr[%d] = %d\n", i % maxSize, arr[i % maxSize]);
        }
    }

    /**
     * 显示队列头数据
     * @return 队列头数据
     */
    public int headQueue() {
        if (isEmpty()) {
            System.out.println("队列空");
        }

        return arr[front];
    }
}
