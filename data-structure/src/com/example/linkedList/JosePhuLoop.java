package com.example.linkedList;

public class JosePhuLoop {
    public static void main(String[] args) {
        CircleSingleLinkedList circleSingleLinkedList = new CircleSingleLinkedList();
        circleSingleLinkedList.addBoy(5);

        circleSingleLinkedList.showBoy();

        // 出圈测试
        System.out.println("出圈测试");
        circleSingleLinkedList.countBoy(1, 2, 5);
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
        // 校验参数合法性
        if (null == first || startNo < 1 || startNo > nums) {
            System.out.println("参数输入有误，请重新输入");
            return;
        }

        // 创建辅助指针
        Boy helper = first;
        // 事先申明指向环形链表的最后这个节点
        while (true) {
            if (helper.getNext() == first) { // 说明helper指向最后一个节点
                break;
            }
            helper = helper.getNext();
        }

        // 报数前，先让 first 和 helper 移动 k - 1 次
        for (int j = 0; j < startNo - 1; j++) {
            first = first.getNext();
            helper = helper.getNext();
        }

        // 先让first 和 helper 指针同时移动 m - 1 次，然后出圈
        // 这里是一个循环操作，直到圈中只有一个节点
        while (true) {
            if (helper == first) { // 说明当前只有一个节点
                break;
            }

            // 让first 和helper 指针同时移动countNum - 1
            for (int j = 0; j < countNum - 1; j++) {
                first = first.getNext();
                helper = helper.getNext();
            }

            // 这时first指向的节点，就是要出圈的节点
            System.out.printf("出圈编号%d \n", first.getNo());
            // 这时将first指向的小孩节点出圈
            first = first.getNext();
            helper.setNext(first);
        }

        System.out.printf("最后还留在圈中的编号%d \n", helper.getNo());
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
