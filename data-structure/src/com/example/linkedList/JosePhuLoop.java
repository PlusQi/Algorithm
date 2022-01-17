package com.example.linkedList;

public class JosePhuLoop {
    public static void main(String[] args) {

    }
}

// 创建一个环形单向链表
class CircleSingleLinkedList {
    // 创建一个first节点
    private Boy first = new Boy(-1);

    // 添加节点，构建一个环形链表
    public void addBoy(int nums) {

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
