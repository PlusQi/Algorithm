package com.example.queue;

public class ArrayQueueDemo {
    public static void main(String[] args) {

    }
}

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
        rear++; // 让rear后移
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


