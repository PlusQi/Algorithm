package com.example.linkedList;

public class JosePhuLoop {
    public static void main(String[] args) {
        CircleSingleLinkedList circleSingleLinkedList = new CircleSingleLinkedList();
        circleSingleLinkedList.addBoy(5);

        circleSingleLinkedList.showBoy();
    }
}

// 创建一个环形单向链表
class CircleSingleLinkedList {
    // 创建一个first节点
    private Boy first = new Boy(-1);

    /**
     * 添加节点，构建一个环形链表
     * @param nums
     */
    public void addBoy(int nums) {
        if (nums < 1) {
            System.out.println("不允许的节点编号");
            return;
        }

        Boy curBoy = null; // 辅助指针，帮助构建环形链表
        for (int i = 1; i <= nums; i++) {
            Boy boy = new Boy(i);
            if (1 == i) {
                first = boy;
                first.setNext(first); // 构成环
                curBoy = first;
            } else {
                curBoy.setNext(boy);
                boy.setNext(first);
                curBoy = boy;
            }
        }
    }

    /**
     * 遍历输出链表
     */
    public void showBoy() {
        // 判断链表是否为空
        if (null == first) {
            System.out.println("链表空");
            return;
        }

        // first节点不能动，使用辅助指针完成遍历
        Boy curBoy = first;
        while (true) {
            System.out.printf("编号%d\n", curBoy.getNo());
            if (curBoy.getNext() == first) // 已完成遍历
                break;

            curBoy = curBoy.getNext(); // curBoy后移
        }
    }

    /**
     * 根据用户输入，计算出小孩出圈的顺序
     * @param startNo 表示从第几个小孩开始数数
     * @param countNum 表示数几个数
     * @param nums 表示最初有多少小孩在圈中
     */
    public void countBoy(int startNo, int countNum, int nums) {

    }
}

class Boy {
    private int no; // 比那好
    private Boy next; // 指向下一个节点，默认为null

    public Boy(int no) {
        this.no = no;
    }

    public int getNo() {
        return no;
    }

    public void setNo(int no) {
        this.no = no;
    }

    public Boy getNext() {
        return next;
    }

    public void setNext(Boy next) {
        this.next = next;
    }

    @Override
    public String toString() {
        return "Boy{" +
                "no=" + no +
                '}';
    }
}
